package edu.zxy.apple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.dao.AccountDao;
import edu.zxy.apple.entity.CreditAccount;
import edu.zxy.apple.vo.CreditAccountVO;

@Controller
public class CreditAccountController
{

    @Autowired
    AccountDao accountDao;

    @RequestMapping(value = "/addCreditAccount", method = RequestMethod.POST)
    public @ResponseBody void addCreditAccount(@RequestBody CreditAccountVO accountVO)
    {
        CreditAccount account = new CreditAccount();
        account.setName(accountVO.getName());
        account.setType(accountVO.getType());
        account.setRoleId(accountVO.getRoleId());
        account.setRemark(accountVO.getRemark());
        account.setCreditLimit(accountVO.getCreditLimit());
        accountDao.add(account);
    }

    @RequestMapping(value = "/delCreditAccount", method = RequestMethod.POST)
    public @ResponseBody void delCreditAccount(@RequestBody CreditAccountVO accountVO)
    {
        CreditAccount account = new CreditAccount();
        account.setId(accountVO.getId());
        accountDao.delete(account);
    }

    @RequestMapping(value = "/updateCreditAccount", method = RequestMethod.POST)
    public @ResponseBody void updateCreditAccount(@RequestBody CreditAccountVO accountVO)
    {
        CreditAccount account = new CreditAccount();
        account.setId(accountVO.getId());
        account.setName(accountVO.getName());
        account.setType(accountVO.getType());
        account.setRoleId(accountVO.getRoleId());
        account.setRemark(accountVO.getRemark());
        account.setCreditLimit(accountVO.getCreditLimit());
        accountDao.update(account);
    }

    @RequestMapping(value = "/getCreditAccount", method = RequestMethod.POST)
    public @ResponseBody CreditAccountVO getCreditAccount(@RequestBody Integer acctId)
    {
        CreditAccount account = (CreditAccount) accountDao.get(acctId);
        CreditAccountVO accountVO = new CreditAccountVO();
        accountVO.setId(account.getId());
        accountVO.setName(account.getName());
        accountVO.setType(account.getType());
        accountVO.setRoleId(account.getRoleId());
        accountVO.setRemark(account.getRemark());
        accountVO.setBalance(account.getBalance());
        accountVO.setCreditLimit(account.getCreditLimit());
        accountVO.setTotalFlowIn(account.getTotalFlowIn());
        accountVO.setTotalFlowOut(account.getTotalFlowOut());
        accountVO.setCreatedDatetime(account.getCreatedDatetime());
        accountVO.setLastUpdatedDatetime(account.getLastUpdatedDatetime());
        return accountVO;
    }
}