package edu.zxy.apple.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.Role;

public class RoleDaoImpl implements BaseDao<Role>
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role t)
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
    public void delete(Role t)
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
    public void update(Role t)
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
    public Role get(Integer id)
    {
        Role role = null;
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            role = session.get(Role.class, id);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return role;
    }

}
