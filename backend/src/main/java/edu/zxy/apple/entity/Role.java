package edu.zxy.apple.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import edu.zxy.apple.enums.RoleType;

@Entity
@Table(name = "role")
public class Role
{
    @Id
    @TableGenerator(name = "roleGen", table = "ID_GEN", pkColumnName = "SEQUENCE_NAME", valueColumnName = "NEXT_VAL", pkColumnValue = "ROLE_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleGen")
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private RoleType type;

    @Column(name = "create_time")
    @FunctionCreationDatetime
    private Date createdDatetime;

    @Column(name = "update_time")
    @FunctionLastUpdatedDatetime
    private Date lastUpdatedDatetime;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
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

    public Date getLastUpdatedDatetime()
    {
        return lastUpdatedDatetime;
    }

}
