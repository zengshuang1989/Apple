package edu.zxy.apple.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.CreditAccount;

public class CreditAccountDaoImpl implements CreditAccountDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CreditAccount> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<CreditAccount> all = null;
        try
        {
            // all = session.createQuery("from account").getResultList();
            CreditAccount acct = session.get(CreditAccount.class, 26);
            all = new ArrayList<CreditAccount>(1);
            all.add(acct);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return all;

    }

    @Override
    public void add(CreditAccount account)
    {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            session.save(account);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();

    }

}
