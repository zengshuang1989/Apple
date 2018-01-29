package edu.zxy.apple.condition.process;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.zxy.apple.condition.managemet.CondProcessorsManager;
import edu.zxy.apple.vo.BaseCondVO;
import edu.zxy.apple.vo.MoneyCondVO;
import edu.zxy.apple.vo.RemarkCondVO;
import edu.zxy.apple.vo.TimeCondVO;

public class RemarkCondProcessor implements CondProcessorInf
{
    @Override
    public void register()
    {
        CondProcessorsManager.getInstance().registerCondProcess("remark", this);
    }
    
    @Override
    public Predicate process(CriteriaBuilder crb, Root root, String cond)
    {
        RemarkCondVO remarkCondVO = null;
        try
        {
            remarkCondVO = (RemarkCondVO) new ObjectMapper().readValue(cond, RemarkCondVO.class);
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Predicate remarkRestriction = null;
        
        if(null != remarkCondVO.getRemark() && remarkCondVO.getRemark().length() > 0)
        {
        remarkRestriction = crb.like(root.get("remark"), "%"+remarkCondVO.getRemark()+"%");
        }

        return remarkRestriction;
    }

    

}
