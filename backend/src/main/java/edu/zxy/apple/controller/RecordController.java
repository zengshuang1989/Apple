package edu.zxy.apple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.dao.RecordDao;
import edu.zxy.apple.entity.Record;
import edu.zxy.apple.vo.RecordVO;

@Controller
public class RecordController
{

    @Autowired
    RecordDao recordDao;

    @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
    public @ResponseBody void addRecord(@RequestBody RecordVO recordVO)
    {
        Record record = new Record();
        record.setCategoryId(recordVO.getCategoryId());
        record.setMoney(recordVO.getMoney());
        record.setRemark(recordVO.getRemark());
        record.setFlowinAcct(recordVO.getFlowinAcct());
        record.setFlowoutAcct(recordVO.getFlowoutAcct());
        recordDao.add(record);
    }

    @RequestMapping(value = "/delRecord", method = RequestMethod.POST)
    public @ResponseBody void delRcord(@RequestBody RecordVO recordVO)
    {
        Record record = new Record();
        record.setId(recordVO.getId());
        recordDao.delete(record);
    }

    @RequestMapping(value = "/updateRecord", method = RequestMethod.POST)
    public @ResponseBody void updateRecord(@RequestBody RecordVO recordVO)
    {
        Record record = new Record();
        record.setId(recordVO.getId());
        record.setCategoryId(recordVO.getCategoryId());
        record.setMoney(recordVO.getMoney());
        record.setRemark(recordVO.getRemark());
        record.setFlowinAcct(recordVO.getFlowinAcct());
        record.setFlowoutAcct(recordVO.getFlowoutAcct());
        recordDao.update(record);
    }

    @RequestMapping(value = "/getRecord", method = RequestMethod.POST)
    public @ResponseBody RecordVO getRecord(@RequestBody Integer recordId)
    {
        Record record = recordDao.get(recordId);
        RecordVO recordVO = new RecordVO();
        recordVO.setId(record.getId());
        recordVO.setCategoryId(record.getCategoryId());
        recordVO.setMoney(record.getMoney());
        recordVO.setRemark(record.getRemark());
        recordVO.setFlowinAcct(record.getFlowinAcct());
        recordVO.setFlowoutAcct(record.getFlowoutAcct());
        recordVO.setCreatedDatetime(record.getCreatedDatetime());
        recordVO.setLastUpdatedDatetime(record.getLastUpdatedDatetime());
        return recordVO;
    }
}