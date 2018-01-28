package edu.zxy.apple.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import edu.zxy.apple.json.BaseCondVODeserialize;

@JsonDeserialize(using = BaseCondVODeserialize.class)
public class BaseCondVO
{
    private String type;

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

}
