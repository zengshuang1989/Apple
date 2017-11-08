package edu.zxy.apple.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.DebitAccount;

public class DebitAccountDaoImpl implements DebitAccountDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<DebitAccount> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<DebitAccount> all = null;
        try
        {
            // all = session.createQuery("from account").getResultList();
            DebitAccount acct = session.get(DebitAccount.class, 27);
            all = new ArrayList<DebitAccount>(1);
            all.add(acct);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return all;

    }

    @Override
    public void add(DebitAccount account)
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
