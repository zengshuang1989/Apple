package edu.zxy.apple.condition.vo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS,include=JsonTypeInfo.As.PROPERTY,property="type")
@JsonSubTypes({@Type(value=MoneyCondVO.class,name="money"),@Type(value=TimeCondVO.class,name="time")})
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
