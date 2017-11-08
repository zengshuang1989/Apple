package edu.zxy.apple.vo;

import java.math.BigDecimal;

import edu.zxy.apple.entity.Account;

public class RecordVO extends BaseVO
{
    private Integer id;

    private Integer categoryId;

    private Account flowoutAcct;

    private Account flowinAcct;

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

    public Account getFlowoutAcct()
    {
        return flowoutAcct;
    }

    public void setFlowoutAcct(Account flowoutAcct)
    {
        this.flowoutAcct = flowoutAcct;
    }

    public Account getFlowinAcct()
    {
        return flowinAcct;
    }

    public void setFlowinAcct(Account flowinAcct)
    {
        this.flowinAcct = flowinAcct;
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
