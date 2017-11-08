package edu.zxy.apple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.dao.CreditAccountDao;
import edu.zxy.apple.entity.CreditAccount;
import edu.zxy.apple.enums.AccountType;
import edu.zxy.apple.vo.CreditAccountVO;

@Controller
public class CreditAccountController
{

    @Autowired
    CreditAccountDao creditAccountDao;

    @RequestMapping(value = "/creditAccount", method = RequestMethod.POST)
    public @ResponseBody CreditAccountVO addCreditAccount(@RequestBody CreditAccountVO account)
    {
        CreditAccount addAccount = new CreditAccount();
        addAccount.setName("test credit account");
        addAccount.setType(AccountType.CASH);
        addAccount.setRemark("test credit account remark.");
        creditAccountDao.add(addAccount);
        return account;
    }

    @RequestMapping(value = "/creditAccount", method = RequestMethod.GET)
    public @ResponseBody List<CreditAccountVO> getAllCreditAccount()
    {
        List<CreditAccount> list = creditAccountDao.getAll();
        List<CreditAccountVO> list2 = new ArrayList<CreditAccountVO>();
        if (list != null)
        {
            for (CreditAccount account : list)
            {
                CreditAccountVO accountVO = new CreditAccountVO();
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