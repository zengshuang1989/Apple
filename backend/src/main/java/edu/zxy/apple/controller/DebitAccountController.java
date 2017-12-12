package edu.zxy.apple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.dao.AccountDao;
import edu.zxy.apple.entity.DebitAccount;
import edu.zxy.apple.vo.DebitAccountVO;

@Controller
public class DebitAccountController
{

    @Autowired
    AccountDao accountDao;

    @RequestMapping(value = "/addDebitAccount", method = RequestMethod.POST)
    public @ResponseBody void addDebitAccount(@RequestBody DebitAccountVO accountVO)
    {

        DebitAccount account = new DebitAccount();
        account.setName(accountVO.getName());
//        account.setType(accountVO.getType());
        account.setRoleId(accountVO.getRoleId());
        account.setRemark(accountVO.getRemark());
        account.setOverdraftFee(accountVO.getOverdraftFee());
        accountDao.add(account);
    }

    @RequestMapping(value = "/delDebitAccount", method = RequestMethod.POST)
    public @ResponseBody void delDebitAccount(@RequestBody DebitAccountVO accountVO)
    {
        DebitAccount account = new DebitAccount();
        account.setId(accountVO.getId());
        accountDao.delete(account);
    }

    @RequestMapping(value = "/updateDebitAccount", method = RequestMethod.POST)
    public @ResponseBody void updateDebitAccount(@RequestBody DebitAccountVO accountVO)
    {
        DebitAccount account = new DebitAccount();
        account.setId(accountVO.getId());
        account.setName(accountVO.getName());
//        account.setType(accountVO.getType());
        account.setRoleId(accountVO.getRoleId());
        account.setRemark(accountVO.getRemark());
        account.setOverdraftFee(accountVO.getOverdraftFee());
        accountDao.update(account);
    }

    @RequestMapping(value = "/getDebitAccount", method = RequestMethod.POST)
    public @ResponseBody DebitAccountVO getDebitAccount(@RequestBody Integer acctId)
    {
        DebitAccount account = (DebitAccount) accountDao.get(acctId);
        DebitAccountVO accountVO = new DebitAccountVO();
        accountVO.setId(account.getId());
        accountVO.setName(account.getName());
//        accountVO.setType(account.getType());
        accountVO.setRoleId(account.getRoleId());
        accountVO.setRemark(account.getRemark());
        accountVO.setBalance(account.getBalance());
        accountVO.setOverdraftFee(account.getOverdraftFee());
        accountVO.setTotalFlowIn(account.getTotalFlowIn());
        accountVO.setTotalFlowOut(account.getTotalFlowOut());
        accountVO.setCreatedDatetime(account.getCreatedDatetime());
        accountVO.setLastUpdatedDatetime(account.getLastUpdatedDatetime());
        return accountVO;
    }
}