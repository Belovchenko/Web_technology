package DAO;

import entities.CourseTeacher_Info;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

public class CourseTeacher_InfoDAOImpl implements CourseTeacher_InfoDAO
{
    public CourseTeacher_Info findById(int id)
    {
        return HibernateSessionFactory.getSessionFactory().openSession().get(CourseTeacher_Info.class, id);
    }

    public void addCourseTeacher_Info(CourseTeacher_Info ct_info)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.save(ct_info);
        T.commit();
        session.close();
    }

    public void updateCourseTeacher_Info(CourseTeacher_Info ct_info)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.update(ct_info);
        T.commit();
        session.close();
    }

    public void deleteCourseTeacher_Info(CourseTeacher_Info ct_info)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.delete(ct_info);
        T.commit();
        session.close();
    }
}
