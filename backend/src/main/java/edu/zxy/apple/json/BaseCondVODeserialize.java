package edu.zxy.apple.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import edu.zxy.apple.vo.BaseCondVO;
import edu.zxy.apple.vo.MoneyCondVO;
import edu.zxy.apple.vo.TimeCondVO;

public class BaseCondVODeserialize extends JsonDeserializer<BaseCondVO>
{

    @Override
    public BaseCondVO deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException
    {
        String type = null;
        BaseCondVO baseCondVO = null;
        JsonToken t = jp.nextToken();
        while (t != JsonToken.END_OBJECT)
        {
            if (t == JsonToken.FIELD_NAME && "type".equals(jp.getCurrentName()))
            {
                t = jp.nextToken();
                type = jp.getText();
                break;
            }
            t = jp.nextToken();
        }

        if (type.equals("money"))
        {
            baseCondVO = jp.readValueAs(MoneyCondVO.class);
        }
        if (type.equals("time"))
        {
            baseCondVO = jp.readValueAs(TimeCondVO.class);
        }
        return baseCondVO;
    }

}
