package edu.zxy.apple.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import edu.zxy.apple.entity.Record;

public class RecordDaoImpl extends BaseDaoImpl<Record> implements RecordDao
{

    @Override
    public List<Record> moneyBetweenQuery(BigDecimal min,BigDecimal max)
    {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Record.class);
        criteria.add(Restrictions.between("money", min, max));
        List<Record> recordList = criteria.list();
        return recordList;
    }

}
