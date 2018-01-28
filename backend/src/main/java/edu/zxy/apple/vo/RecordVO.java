package edu.zxy.apple.vo;

import edu.zxy.apple.entity.Account;
import edu.zxy.apple.entity.Category;

public class RecordVO extends BaseVO
{
    private Integer id;

    private Category category;

    private Account flowoutAcct;

    private Account flowinAcct;

    private double money;
    
    private String remark;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
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

    public double getMoney()
    {
        return money;
    }

    public void setMoney(double money)
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
