package edu.zxy.apple.vo;

import java.math.BigDecimal;
import java.util.List;

public class RecordCondVO
{
    private BigDecimal minMoney;
    
    private BigDecimal maxMoney;
    
    private List<BigDecimal> acctIdList;
    
    private String remark;

    public BigDecimal getMinMoney()
    {
        return minMoney;
    }

    public void setMinMoney(BigDecimal minMoney)
    {
        this.minMoney = minMoney;
    }

    public BigDecimal getMaxMoney()
    {
        return maxMoney;
    }

    public void setMaxMoney(BigDecimal maxMoney)
    {
        this.maxMoney = maxMoney;
    }

    public List<BigDecimal> getAcctIdList()
    {
        return acctIdList;
    }

    public void setAcctIdList(List<BigDecimal> acctIdList)
    {
        this.acctIdList = acctIdList;
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
