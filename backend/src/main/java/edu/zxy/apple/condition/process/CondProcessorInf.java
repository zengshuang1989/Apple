package edu.zxy.apple.condition.process;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import edu.zxy.apple.vo.BaseCondVO;

public interface CondProcessorInf
{
    public void register();
    
    public Predicate process(CriteriaBuilder crb, Root root,String cond);
}
