package edu.zxy.apple.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.Record;

public class RecordDaoImpl implements BaseDao<Record>
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Record t)
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
    public void delete(Record t)
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
    public void update(Record t)
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
    public Record get(Integer id)
    {
        Record record = null;
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            record = session.get(Record.class, id);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return record;
    }

}
