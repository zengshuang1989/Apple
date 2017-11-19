package edu.zxy.apple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.dao.BaseDao;
import edu.zxy.apple.entity.Account;
import edu.zxy.apple.vo.AccountVO;

@Controller
public class AccountController
{

    @Autowired
    BaseDao<Account> accountDao;

    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public @ResponseBody void addAccount(@RequestBody AccountVO accountVO)
    {
        Account account = new Account();
        account.setName(accountVO.getName());
        account.setType(accountVO.getType());
        account.setRoleId(accountVO.getRoleId());
        account.setRemark(accountVO.getRemark());
        accountDao.add(account);
    }

    @RequestMapping(value = "/delAccount", method = RequestMethod.POST)
    public @ResponseBody void delAccount(@RequestBody AccountVO accountVO)
    {
        Account account = new Account();
        account.setId(accountVO.getId());
        accountDao.delete(account);

    }

    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
    public @ResponseBody void updateAccount(@RequestBody AccountVO accountVO)
    {
        Account account = new Account();
        account.setId(accountVO.getId());
        account.setName(accountVO.getName());
        account.setType(accountVO.getType());
        account.setRoleId(accountVO.getRoleId());
        account.setRemark(accountVO.getRemark());
        accountDao.update(account);
    }

    @RequestMapping(value = "/getAccount", method = RequestMethod.POST)
    public @ResponseBody AccountVO getAccount(@RequestBody Integer acctId)
    {
        Account account = accountDao.get(acctId);
        AccountVO accountVO = new AccountVO();
        accountVO.setId(account.getId());
        accountVO.setName(account.getName());
        accountVO.setType(account.getType());
        accountVO.setRoleId(account.getRoleId());
        accountVO.setRemark(account.getRemark());
        accountVO.setBalance(account.getBalance());
        accountVO.setTotalFlowIn(account.getTotalFlowIn());
        accountVO.setTotalFlowOut(account.getTotalFlowOut());
        accountVO.setCreatedDatetime(account.getCreatedDatetime());
        accountVO.setLastUpdatedDatetime(account.getLastUpdatedDatetime());
        return accountVO;
    }
}