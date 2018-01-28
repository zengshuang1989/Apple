package edu.zxy.apple.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import edu.zxy.apple.enums.CategoryType;

public class RecordCondVO
{
    /**
     * 4种模式，上限，下限，区间，定额
     */
    private BigDecimal minMoney;
    
    private BigDecimal maxMoney;
    
    /**
     * 4种模式，年，月，日，区间
     */
    private Timestamp beginTime;
    
    private Timestamp endTime;
    
    /**
     * 帐户
     */
    private List<BigDecimal> acctIdList;
    
    /**
     * 收支分类
     */
    private CategoryType categoryType;    
    
    /**
     * 备注，模糊查询
     */
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

    public Timestamp getBeginTime()
    {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime)
    {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Timestamp endTime)
    {
        this.endTime = endTime;
    }

    public List<BigDecimal> getAcctIdList()
    {
        return acctIdList;
    }

    public void setAcctIdList(List<BigDecimal> acctIdList)
    {
        this.acctIdList = acctIdList;
    }

    public CategoryType getCategoryType()
    {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType)
    {
        this.categoryType = categoryType;
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
