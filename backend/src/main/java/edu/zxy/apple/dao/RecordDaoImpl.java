package edu.zxy.apple.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import edu.zxy.apple.entity.Record;
import edu.zxy.apple.vo.RecordCondVO;

public class RecordDaoImpl extends BaseDaoImpl<Record> implements RecordDao
{

    @Override
    public List<Record> queryRecord(RecordCondVO recordCondVO)
    {
        Session session = getSession();
        CriteriaBuilder crb = session.getCriteriaBuilder();
        CriteriaQuery<Record> criteria = crb.createQuery(Record.class);
        Root<Record> root = criteria.from(Record.class);
        criteria.select(root);
        
        //金额
        if(null != recordCondVO.getMinMoney() && null != recordCondVO.getMaxMoney())
        {
            criteria.where(crb.between(root.get("money"), recordCondVO.getMinMoney(), recordCondVO.getMaxMoney()));
        }
        else if(null != recordCondVO.getMinMoney() && null == recordCondVO.getMaxMoney())
        {
            criteria.where(crb.greaterThanOrEqualTo(root.get("money"), recordCondVO.getMinMoney()));
        }
        else if(null == recordCondVO.getMinMoney() && null != recordCondVO.getMaxMoney())
        {
            criteria.where(crb.lessThanOrEqualTo(root.get("money"), recordCondVO.getMaxMoney()));
        }
       
        return session.createQuery(criteria).getResultList();
    }

}
