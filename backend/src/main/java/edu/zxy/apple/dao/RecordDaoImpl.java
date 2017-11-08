package edu.zxy.apple.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.Record;

public class RecordDaoImpl implements RecordDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Record> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Record> all = null;
        try
        {
//            all = session.createQuery("from Record").getResultList();
            Record record = session.get(Record.class, 1);
            all = new ArrayList<Record>(1);
            all.add(record);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return all;

    }

    @Override
    public void add(Record record)
    {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            session.save(record);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();

    }

}
