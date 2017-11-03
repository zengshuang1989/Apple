package edu.zxy.apple.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.Account;

public class AccountDaoImpl implements AccountDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<Account> getAll() {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Account> all = null;
        try{
            //all = session.createQuery("from account").getResultList();
            Account acct = session.get(Account.class, 1);
            all = new ArrayList<Account>(1);
            all.add(acct);
        }catch(HibernateException e){
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return all;

	}

	@Override
	public void add(Account account) {
		 Session session = sessionFactory.getCurrentSession();
	        try{
	            session.beginTransaction();
	            session.save(account);
	        }catch(HibernateException e){
	            session.getTransaction().rollback();
	        }
	        session.getTransaction().commit();


	}

}
