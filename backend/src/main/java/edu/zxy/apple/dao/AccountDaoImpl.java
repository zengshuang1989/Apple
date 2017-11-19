package edu.zxy.apple.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.Account;

public class AccountDaoImpl implements BaseDao<Account>
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Account t)
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
    public void delete(Account t)
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
    public void update(Account t)
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
    public Account get(Integer id)
    {
        Account account = null;
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            account = session.get(Account.class, id);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return account;
    }

}
