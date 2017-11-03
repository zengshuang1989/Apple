package edu.zxy.apple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zxy.apple.dao.AccountDao;
import edu.zxy.apple.entity.Account;
import edu.zxy.apple.enums.AccountType;
import edu.zxy.apple.vo.AccountVO;

@Controller
public class AccoutController {

	@Autowired
	AccountDao accountDao;
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public @ResponseBody AccountVO addAccount(@RequestBody AccountVO account) {
		Account addAccount = new Account();
		addAccount.setName("test account");
		addAccount.setType(AccountType.CASH);
		addAccount.setRemark("test account remark.");
		accountDao.add(addAccount);
		return account;
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public @ResponseBody List<AccountVO> getAllAccount() {
		List<Account> list = accountDao.getAll();
		List<AccountVO> list2= new ArrayList<AccountVO>();
		if(list!=null){
            for(Account account:list){
                AccountVO accountVO = new AccountVO();
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