package edu.zxy.apple.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import edu.zxy.apple.entity.Account;
import edu.zxy.apple.entity.Category;
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
        Join<Record, Account> flowoutAcctJoin = root.join("flowoutAcct",JoinType.LEFT);
        Join<Record, Account> flowinAcctJoin = root.join("flowinAcct",JoinType.LEFT);
        Join<Record, Category> ownCategoryJoin = root.join("ownCategory",JoinType.LEFT);
        criteria.select(root);
        List<Predicate> predicatesList = new ArrayList<Predicate>();

        // 金额
        Predicate moneyRestriction = null;
        if (null != recordCondVO.getMinMoney() && null != recordCondVO.getMaxMoney())
        {
            moneyRestriction = crb.between(root.get("money"), recordCondVO.getMinMoney(), recordCondVO.getMaxMoney());
        } else if (null != recordCondVO.getMinMoney() && null == recordCondVO.getMaxMoney())
        {
            moneyRestriction = crb.greaterThanOrEqualTo(root.get("money"), recordCondVO.getMinMoney());
        } else if (null == recordCondVO.getMinMoney() && null != recordCondVO.getMaxMoney())
        {
            moneyRestriction = crb.lessThanOrEqualTo(root.get("money"), recordCondVO.getMaxMoney());
        }
        
        addRestriction(moneyRestriction,predicatesList);

        // 时间
        Predicate timeRestriction = null;
        if (null != recordCondVO.getBeginTime() && null != recordCondVO.getEndTime())
        {
            timeRestriction = crb.between(root.get("createdDatetime"), recordCondVO.getBeginTime(),
                    recordCondVO.getEndTime());
        }
        
        addRestriction(timeRestriction,predicatesList);

        // 帐户
        Predicate accountRestriction = null;
        if (null != recordCondVO.getAcctIdList() && !recordCondVO.getAcctIdList().isEmpty())
        {
            accountRestriction = crb.or(flowoutAcctJoin.get("id").in(recordCondVO.getAcctIdList()),
                    flowinAcctJoin.get("id").in(recordCondVO.getAcctIdList()));
        }
        
        addRestriction(accountRestriction,predicatesList);
        
        Predicate categoryTypeRestriction = null;
        if(null != recordCondVO.getCategoryType())
        {
            categoryTypeRestriction = crb.equal(ownCategoryJoin.get("type"), recordCondVO.getCategoryType());
        }
        addRestriction(categoryTypeRestriction,predicatesList);
        
        Predicate remarkRestriction = null;
        if(null != recordCondVO.getRemark() && !recordCondVO.getRemark().isEmpty())
        {
            remarkRestriction = crb.like(root.get("remark"), "%"+recordCondVO.getRemark()+"%");
        }
        addRestriction(remarkRestriction,predicatesList);
        
        criteria.where(predicatesList.toArray(new Predicate[predicatesList.size()]));

        return session.createQuery(criteria).getResultList();
    }
    
    private void addRestriction(Predicate predicate, List<Predicate> predicateList)
    {
        if(predicate != null)
        {
            predicateList.add(predicate);
        }
    }

}
