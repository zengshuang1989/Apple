package edu.zxy.apple.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Formula;

import edu.zxy.apple.enums.AccountType;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account extends Base
{

    @Id
    @TableGenerator(name = "acctGen", table = "ID_GEN", pkColumnName = "SEQUENCE_NAME", valueColumnName = "NEXT_VAL", pkColumnValue = "ACCT_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "acctGen")
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Column(name = "role_id")
    private Integer roleId;

    private String remark;

    @Formula(value = "(select sum(t.money) from record t where t.flowin_acct_id = id)")
    private BigDecimal totalFlowIn;

    @Formula(value = "(select sum(t.money) from record t where t.flowout_acct_id = id)")
    private BigDecimal totalFlowOut;

    @Formula(value = "((select sum(t.money) from record t where t.flowin_acct_id = id)-(select sum(t.money) from record t where t.flowout_acct_id = id))")
    private BigDecimal balance;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public AccountType getType()
    {
        return type;
    }

    public void setType(AccountType cash)
    {
        this.type = cash;
    }

    public Integer getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Integer roleId)
    {
        this.roleId = roleId;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public BigDecimal getTotalFlowIn()
    {
        return totalFlowIn;
    }

    public BigDecimal getTotalFlowOut()
    {
        return totalFlowOut;
    }

    public BigDecimal getBalance()
    {
        return balance;
    }

}
