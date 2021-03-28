package DAO;

import entities.CourseStudent_Info;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

public class CourseStudent_InfoDAOImpl implements CourseStudent_InfoDAO
{
    public CourseStudent_Info findById(int id)
    {
        return HibernateSessionFactory.getSessionFactory().openSession().get(CourseStudent_Info.class, id);
    }

    public void addCourseStudent_Info(CourseStudent_Info cs_info)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.save(cs_info);
        T.commit();
        session.close();
    }

    public void updateCourseStudent_Info(CourseStudent_Info cs_info)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.update(cs_info);
        T.commit();
        session.close();
    }

    public void deleteCourseStudent_Info(CourseStudent_Info cs_info)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.delete(cs_info);
        T.commit();
        session.close();
    }
}
