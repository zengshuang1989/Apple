package edu.zxy.apple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.dao.DebitAccountDao;
import edu.zxy.apple.entity.DebitAccount;
import edu.zxy.apple.enums.AccountType;
import edu.zxy.apple.vo.DebitAccountVO;

@Controller
public class DebitAccountController
{

    @Autowired
    DebitAccountDao debitAccountDao;

    @RequestMapping(value = "/debitAccount", method = RequestMethod.POST)
    public @ResponseBody DebitAccountVO addDebitAccount(@RequestBody DebitAccountVO account)
    {
        DebitAccount addAccount = new DebitAccount();
        addAccount.setName("test account");
        addAccount.setType(AccountType.CASH);
        addAccount.setRemark("test account remark.");
        debitAccountDao.add(addAccount);
        return account;
    }

    @RequestMapping(value = "/debitAccount", method = RequestMethod.GET)
    public @ResponseBody List<DebitAccountVO> getAllDebitAccount()
    {
        List<DebitAccount> list = debitAccountDao.getAll();
        List<DebitAccountVO> list2 = new ArrayList<DebitAccountVO>();
        if (list != null)
        {
            for (DebitAccount account : list)
            {
                DebitAccountVO accountVO = new DebitAccountVO();
                accountVO.setId(account.getId());
                accountVO.setName(account.getName());
                accountVO.setType(account.getType());
                accountVO.setRemark(account.getRemark());
                accountVO.setBalance(account.getBalance());
                accountVO.setTotalFlowIn(account.getTotalFlowIn());
                accountVO.setTotalFlowOut(account.getTotalFlowOut());
                accountVO.setCreatedDatetime(account.getCreatedDatetime());
                accountVO.setLastUpdatedDatetime(account.getLastUpdatedDatetime());
                list2.add(accountVO);
            }
        }

        return list2;
    }
}