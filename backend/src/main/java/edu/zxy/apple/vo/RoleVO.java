package edu.zxy.apple.vo;

import edu.zxy.apple.enums.RoleType;

public class RoleVO extends BaseVO
{

    private Integer id;

    private String name;

    private RoleType type;


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

    public void setId(Integer id)
    {
        this.id = id;
    }

}
