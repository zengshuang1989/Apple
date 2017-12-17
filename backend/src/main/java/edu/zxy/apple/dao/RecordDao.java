package edu.zxy.apple.dao;

import java.math.BigDecimal;
import java.util.List;

import edu.zxy.apple.entity.Record;

public interface RecordDao extends BaseDao<Record>
{
    public List<Record> moneyBetweenQuery(BigDecimal min,BigDecimal max);
}
