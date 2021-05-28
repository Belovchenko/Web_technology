package DAO;

import entities.CourseTeacher_Info;
import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;

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

    public List<CourseTeacher_Info> getAll() {
        Session session = null;
        List<CourseTeacher_Info> ct_info = new ArrayList<CourseTeacher_Info>();
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query<CourseTeacher_Info> query = session.createQuery("FROM CourseTeacher_Info", CourseTeacher_Info.class);
        ct_info = (List<CourseTeacher_Info>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return ct_info;
    }
}
