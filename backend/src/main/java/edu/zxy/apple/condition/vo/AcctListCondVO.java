package edu.zxy.apple.condition.vo;

import java.math.BigDecimal;
import java.util.List;

public class AcctListCondVO extends BaseCondVO
{
    private List<BigDecimal> acctIdList;

    public List<BigDecimal> getAcctIdList()
    {
        return acctIdList;
    }

    public void setAcctIdList(List<BigDecimal> acctIdList)
    {
        this.acctIdList = acctIdList;
    }

}
