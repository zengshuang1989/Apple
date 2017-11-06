package edu.zxy.apple.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Record extends Base
{
    @Id
    @TableGenerator(name = "recordGen", table = "ID_GEN", pkColumnName = "SEQUENCE_NAME", valueColumnName = "NEXT_VAL", pkColumnValue = "RECORD_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "recordGen")
    private Integer id;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "flowout_acct_id")
    private Integer flowoutAcctId;

    @Column(name = "flowin_acct_id")
    private Integer flowinAcctId;

    private BigDecimal money;

    private String remark;


    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    public Integer getFlowoutAcctId()
    {
        return flowoutAcctId;
    }

    public void setFlowoutAcctId(Integer flowoutAcctId)
    {
        this.flowoutAcctId = flowoutAcctId;
    }

    public Integer getFlowinAcctId()
    {
        return flowinAcctId;
    }

    public void setFlowinAcctId(Integer flowinAcctId)
    {
        this.flowinAcctId = flowinAcctId;
    }

    public BigDecimal getMoney()
    {
        return money;
    }

    public void setMoney(BigDecimal money)
    {
        this.money = money;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }


}
