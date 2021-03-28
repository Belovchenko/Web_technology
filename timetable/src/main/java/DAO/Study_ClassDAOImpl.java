package DAO;

import entities.Study_Class;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

public class Study_ClassDAOImpl implements Study_ClassDAO
{
    public Study_Class findById(int id)
    {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Study_Class.class, id);
    }

    public void addStudy_Class(Study_Class study_class)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.save(study_class);
        T.commit();
        session.close();
    }

    public void updateStudy_Class(Study_Class study_class)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.update(study_class);
        T.commit();
        session.close();
    }

    public void deleteStudy_Class(Study_Class study_class)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.delete(study_class);
        T.commit();
        session.close();
    }
}
