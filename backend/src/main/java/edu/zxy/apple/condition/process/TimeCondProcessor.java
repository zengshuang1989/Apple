package edu.zxy.apple.condition.process;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import edu.zxy.apple.condition.managemet.CondProcessorsManager;
import edu.zxy.apple.condition.vo.BaseCondVO;
import edu.zxy.apple.condition.vo.TimeCondVO;

public class TimeCondProcessor implements CondProcessorInf
{
    @Override
    public void register()
    {
        CondProcessorsManager.getInstance().registerCondProcess("time", this);
    }
    
    @Override
    public Predicate process(CriteriaBuilder crb, Root root, BaseCondVO cond)
    {
        TimeCondVO timeCondVO = (TimeCondVO) cond;

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
