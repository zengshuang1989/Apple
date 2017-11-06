package edu.zxy.apple.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zxy.apple.entity.Role;

public class RoleDaoImpl implements RoleDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Role> all = null;
        try
        {
            all = session.createQuery("from Role").getResultList();
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return all;

    }

    @Override
    public void add(Role role)
    {
        Session session = sessionFactory.getCurrentSession();
        try
        {
            session.beginTransaction();
            session.save(role);
        } catch (HibernateException e)
        {
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();

    }

}
