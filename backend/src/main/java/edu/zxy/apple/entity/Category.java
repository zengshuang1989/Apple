package edu.zxy.apple.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import edu.zxy.apple.enums.CategoryType;

@Entity
public class Category extends Base
{
    @Id
    @TableGenerator(name = "categoryGen", table = "ID_GEN", pkColumnName = "SEQUENCE_NAME", valueColumnName = "NEXT_VAL", pkColumnValue = "CATEGORY_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "categoryGen")
    private Integer id;

    private Integer pid;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryType type;


    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getPid()
    {
        return pid;
    }

    public void setPid(Integer pid)
    {
        this.pid = pid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public CategoryType getType()
    {
        return type;
    }

    public void setType(CategoryType type)
    {
        this.type = type;
    }


}
