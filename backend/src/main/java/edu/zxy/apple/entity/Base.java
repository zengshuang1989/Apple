package edu.zxy.apple.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Base
{
    @Column(name = "create_time")
    @FunctionCreationDatetime
    private Timestamp createdDatetime;

    @Column(name = "update_time")
    @FunctionLastUpdatedDatetime
    private Timestamp lastUpdatedDatetime;
    
    public Timestamp getCreatedDatetime()
    {
        return createdDatetime;
    }

    public Timestamp getLastUpdatedDatetime()
    {
        return lastUpdatedDatetime;
    }
}
