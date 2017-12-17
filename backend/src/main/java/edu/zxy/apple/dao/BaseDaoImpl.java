package edu.zxy.apple.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoImpl<T> implements BaseDao<T>
{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public void add(T t)
    {
        Session session = getSession();
//        try
//        {
//            session.beginTransaction();
            session.save(t);
//        } catch (HibernateException e)
//        {
//            session.getTransaction().rollback();
//        }
//        session.getTransaction().commit();

    }

    @Override
    public void delete(T t)
    {
        Session session = sessionFactory.getCurrentSession();
//        try
//        {
//            session.beginTransaction();
            session.delete(t);
//        } catch (HibernateException e)
//        {
//            session.getTransaction().rollback();
//        }
//        session.getTransaction().commit();

    }

    @Override
    public void update(T t)
    {
        Session session = sessionFactory.getCurrentSession();
//        try
//        {
//            session.beginTransaction();
            session.update(t);
//        } catch (HibernateException e)
//        {
//            session.getTransaction().rollback();
//        }
//        session.getTransaction().commit();

    }

    @Override
    public T get(Integer id)
    {
        T t = null;
        Session session = sessionFactory.getCurrentSession();
//        try
//        {
//            session.beginTransaction();
            t = session.get((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0], id);
//        } catch (HibernateException e)
//        {
//            session.getTransaction().rollback();
//        }
//        session.getTransaction().commit();
        return t;
    }

}
