package edu.zxy.apple.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.zxy.apple.dao.AccountDao;
import edu.zxy.apple.dao.RoleDao;
import edu.zxy.apple.entity.Account;
import edu.zxy.apple.entity.Role;
import edu.zxy.apple.enums.AccountType;
import edu.zxy.apple.enums.RoleType;

@Transactional
public class TestAnnotationTransationBean
{
    @Autowired
    AccountDao accountDao;
    
    @Autowired
    RoleDao roleDao;
    
    public void testOperateDatabase()
    {
        Account account = new Account();
        account.setName("121202");
        account.setType(AccountType.CASH);
        accountDao.add(account);
  
        Role role = new Role();
        role.setName("121202");
        role.setType(RoleType.FAMILY);
        roleDao.add(role );
          
    }
}
