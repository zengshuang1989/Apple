package edu.zxy.apple.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.DebitAccount;

public class DebitAccountDaoImpl implements BaseDao<DebitAccount>
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(DebitAccount t)
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
    public void delete(DebitAccount t)
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
    public void update(DebitAccount t)
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
    public DebitAccount get(Integer id)
    {
        DebitAccount account = null;
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            account = session.get(DebitAccount.class, id);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return account;
    }

}
