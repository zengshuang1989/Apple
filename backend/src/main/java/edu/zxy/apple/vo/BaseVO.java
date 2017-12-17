package edu.zxy.apple.vo;

import java.sql.Timestamp;

public class BaseVO
{
    private Timestamp createdDatetime;

    private Timestamp lastUpdatedDatetime;

    public Timestamp getCreatedDatetime()
    {
        return createdDatetime;
    }

    public void setCreatedDatetime(Timestamp createdDatetime)
    {
        this.createdDatetime = createdDatetime;
    }

    public Timestamp getLastUpdatedDatetime()
    {
        return lastUpdatedDatetime;
    }

    public void setLastUpdatedDatetime(Timestamp lastUpdatedDatetime)
    {
        this.lastUpdatedDatetime = lastUpdatedDatetime;
    }
    
    
}
