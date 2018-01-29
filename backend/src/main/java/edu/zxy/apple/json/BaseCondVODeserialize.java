package edu.zxy.apple.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.zxy.apple.vo.BaseCondVO;
import edu.zxy.apple.vo.MoneyCondVO;
import edu.zxy.apple.vo.TimeCondVO;

public class BaseCondVODeserialize extends JsonDeserializer<BaseCondVO>
{

    @Override
    public BaseCondVO deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException
    {
      /*  StringBuffer content = new StringBuffer();
        String type = null;
        BaseCondVO baseCondVO = null;
        JsonToken jk = null;
        while (jp.hasCurrentToken())
        {
            jk = jp.getCurrentToken();
            
            if (jk == JsonToken.FIELD_NAME && "type".equals(jp.getCurrentName()))
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
        }*/
        ObjectMapper mapper = new ObjectMapper(); 
        BaseCondVO baseCondVO = mapper.readValue(jp, MoneyCondVO.class);
        return baseCondVO;
    }

}
