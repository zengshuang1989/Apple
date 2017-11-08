package edu.zxy.apple.dao;

import java.util.List;

import edu.zxy.apple.entity.Record;

public interface RecordDao
{
    public List<Record> getAll();

    public void add(Record record);

}
