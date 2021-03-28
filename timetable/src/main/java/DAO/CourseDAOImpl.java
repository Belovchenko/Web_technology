package DAO;

import entities.Course;
import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

public class CourseDAOImpl implements CourseDAO
{
    public Course findById(int id)
    {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Course.class, id);
    }

    public void addCourse(Course course)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.save(course);
        T.commit();
        session.close();
    }

    public void updateCourse(Course course)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.update(course);
        T.commit();
        session.close();
    }

    public void deleteCourse(Course course)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.delete(course);
        T.commit();
        session.close();
    }

    /*void addNewCourseTeacher(Course course, Teacher teacher)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();

    }*/
}
