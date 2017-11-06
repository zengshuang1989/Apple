package edu.zxy.apple.vo;

import java.sql.Date;

import edu.zxy.apple.enums.RoleType;

public class RoleVO
{

    private Integer id;

    private String name;

    private RoleType type;

    private Date createdDatetime;

    private Date lastUpdatedDatetime;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public RoleType getType()
    {
        return type;
    }

    public void setType(RoleType type)
    {
        this.type = type;
    }

    public Date getCreatedDatetime()
    {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime)
    {
        this.createdDatetime = createdDatetime;
    }

    public Date getLastUpdatedDatetime()
    {
        return lastUpdatedDatetime;
    }

    public void setLastUpdatedDatetime(Date lastUpdatedDatetime)
    {
        this.lastUpdatedDatetime = lastUpdatedDatetime;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

}
