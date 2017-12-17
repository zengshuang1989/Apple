package edu.zxy.apple.bean;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.dao.AccountDao;
import edu.zxy.apple.dao.RoleDao;
import edu.zxy.apple.entity.Account;
import edu.zxy.apple.entity.Role;
import edu.zxy.apple.enums.AccountType;
import edu.zxy.apple.enums.RoleType;

public class TestJDBCTransationBean
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    AccountDao accountDao;
    
    @Autowired
    RoleDao roleDao;
    
    public void testOperateDatabase()
    {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            
            Account account = new Account();
            account.setName("121201");
            accountDao.add(account);
      
            Role role = new Role();
            role.setName("121201");
            role.setType(RoleType.FAMILY);
            roleDao.add(role );
            
            session.getTransaction().commit();
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        
    }
}
