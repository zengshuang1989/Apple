package edu.zxy.apple.condition.process;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.zxy.apple.condition.managemet.CondProcessorsManager;
import edu.zxy.apple.vo.BaseCondVO;
import edu.zxy.apple.vo.MoneyCondVO;
import edu.zxy.apple.vo.TimeCondVO;

public class TimeCondProcessor implements CondProcessorInf
{
    @Override
    public void register()
    {
        CondProcessorsManager.getInstance().registerCondProcess("time", this);
    }
    
    @Override
    public Predicate process(CriteriaBuilder crb, Root root, String cond)
    {
        TimeCondVO timeCondVO = null;
        try
        {
            timeCondVO = (TimeCondVO) new ObjectMapper().readValue(cond, TimeCondVO.class);
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Predicate timeRestriction = null;
        if (null != timeCondVO.getBeginTime() && null != timeCondVO.getEndTime())
        {
            timeRestriction = crb.between(root.get("createdDatetime"), timeCondVO.getBeginTime(),
                    timeCondVO.getEndTime());
        } else if (null != timeCondVO.getBeginTime() && null == timeCondVO.getEndTime())
        {
            timeRestriction = crb.greaterThanOrEqualTo(root.get("createdDatetime"), timeCondVO.getBeginTime());
        } else if (null == timeCondVO.getBeginTime() && null != timeCondVO.getEndTime())
        {
            timeRestriction = crb.lessThanOrEqualTo(root.get("createdDatetime"), timeCondVO.getEndTime());
        }

        return timeRestriction;
    }

    

}
