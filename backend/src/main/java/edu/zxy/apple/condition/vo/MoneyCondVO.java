package edu.zxy.apple.condition.vo;

import java.math.BigDecimal;

public class MoneyCondVO extends BaseCondVO
{
    private BigDecimal minMoney;

    private BigDecimal maxMoney;

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

}
