package edu.zxy.apple.dao;

import java.util.List;

import edu.zxy.apple.entity.Record;
import edu.zxy.apple.vo.RecordCondVO;

public interface RecordDao extends BaseDao<Record>
{
    public List<Record> queryRecord(RecordCondVO recordCondVO);
    
}
