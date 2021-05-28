package DAO;

import entities.Auditorium;
import entities.CourseStudent_Info;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.List;

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

    public List<CourseStudent_Info> getAll() {
        Session session = null;
        List<CourseStudent_Info> cs_info = new ArrayList<CourseStudent_Info>();
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query<CourseStudent_Info> query = session.createQuery("FROM CourseStudent_Info", CourseStudent_Info.class);
        cs_info = (List<CourseStudent_Info>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return cs_info;
    }
}
