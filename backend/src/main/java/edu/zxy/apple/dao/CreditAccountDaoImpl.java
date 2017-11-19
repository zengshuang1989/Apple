package edu.zxy.apple.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.CreditAccount;

public class CreditAccountDaoImpl implements BaseDao<CreditAccount>
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(CreditAccount t)
    {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            session.save(t);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();

    }

    @Override
    public void delete(CreditAccount t)
    {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            session.delete(t);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();

    }

    @Override
    public void update(CreditAccount t)
    {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            session.update(t);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();

    }

    @Override
    public CreditAccount get(Integer id)
    {
        CreditAccount account = null;
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            account = session.get(CreditAccount.class, id);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return account;
    }

}
