package edu.zxy.apple.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.dao.RecordDao;
import edu.zxy.apple.entity.Account;
import edu.zxy.apple.entity.Record;
import edu.zxy.apple.vo.RecordVO;

@Controller
public class RecordController
{

    @Autowired
    RecordDao recordDao;

    @RequestMapping(value = "/record", method = RequestMethod.POST)
    public @ResponseBody RecordVO addRecord(@RequestBody RecordVO account)
    {
        Record addRecord = new Record();
        addRecord.setCategoryId(1);
        addRecord.setMoney(new BigDecimal(119));
        addRecord.setRemark("test consume.");
        Account flowoutAcct = new Account();
        flowoutAcct.setId(1);
        addRecord.setFlowoutAcct(flowoutAcct );
        recordDao.add(addRecord);
        return account;
    }

    @RequestMapping(value = "/record", method = RequestMethod.GET)
    public @ResponseBody List<RecordVO> getAllRecord()
    {
        List<Record> list = recordDao.getAll();
        List<RecordVO> list2 = new ArrayList<RecordVO>();
        if (list != null)
        {
            for (Record record : list)
            {
                RecordVO recordVO = new RecordVO();
                recordVO.setId(record.getId());
                recordVO.setCategoryId(record.getCategoryId());
                recordVO.setRemark(record.getRemark());
                recordVO.setFlowinAcct(record.getFlowinAcct());
                recordVO.setFlowoutAcct(record.getFlowoutAcct());
                recordVO.setMoney(record.getMoney());
                list2.add(recordVO);
            }
        }

        return list2;
    }
}