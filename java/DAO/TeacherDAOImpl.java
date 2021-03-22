package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Teacher;
import utils.HibernateSessionFactory;

public class TeacherDAOImpl implements TeacherDAO
{
    public Teacher findById(int id)
    {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Teacher.class, id);
    }

    public void addTeacher(Teacher teacher)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.save(teacher);
        T.commit();
        session.close();
    }

    /*public void updateTeacher(Teacher teacher)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.update(teacher);
        T.commit();
        session.close();
    }*/

    public void deleteTeacher(Teacher teacher)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.delete(teacher);
        T.commit();
        session.close();
    }
}
