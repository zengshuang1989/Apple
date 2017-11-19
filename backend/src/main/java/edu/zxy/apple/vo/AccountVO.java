package edu.zxy.apple.vo;

import java.math.BigDecimal;

import edu.zxy.apple.enums.AccountType;

public class AccountVO extends BaseVO
{

    private Integer id;

    private String name;

    private AccountType type;

    private Integer roleId;

    private String remark;


    private BigDecimal totalFlowIn;

    private BigDecimal totalFlowOut;

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

    public void setType(AccountType accountType)
    {
        this.type = accountType;
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

    public void setTotalFlowIn(BigDecimal totalFlowIn)
    {
        this.totalFlowIn = totalFlowIn;
    }

    public void setTotalFlowOut(BigDecimal totalFlowOut)
    {
        this.totalFlowOut = totalFlowOut;
    }

    public void setBalance(BigDecimal balance)
    {
        this.balance = balance;
    }

}
