package edu.zxy.apple.condition.vo;

import java.util.List;

public class AcctListCondVO extends BaseCondVO
{
    private List<Integer> acctIdList;

    public List<Integer> getAcctIdList()
    {
        return acctIdList;
    }

    public void setAcctIdList(List<Integer> acctIdList)
    {
        this.acctIdList = acctIdList;
    }

}
