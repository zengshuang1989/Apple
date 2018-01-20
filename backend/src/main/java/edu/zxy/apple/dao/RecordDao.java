package edu.zxy.apple.dao;

import java.util.List;

import edu.zxy.apple.condition.vo.BaseCondVO;
import edu.zxy.apple.entity.Record;

public interface RecordDao extends BaseDao<Record>
{
    public List<Record> queryRecord(List<BaseCondVO> condList);
    
}
