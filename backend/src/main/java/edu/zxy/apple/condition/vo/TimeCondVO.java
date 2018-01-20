package edu.zxy.apple.condition.vo;

import java.sql.Timestamp;

public class TimeCondVO extends BaseCondVO
{
    private Timestamp beginTime;

    private Timestamp endTime;

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

}
