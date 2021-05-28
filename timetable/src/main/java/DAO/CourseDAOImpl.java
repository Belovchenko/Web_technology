package DAO;

import entities.Course;
import entities.Study_Class;
import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO
{
    public Course findById(int id)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
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

    public List<Course> getAll() {
        Session session = null;
        List<Course> courses = new ArrayList<Course>();
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Course> query = session.createQuery("FROM Course", Course.class);
        courses = (List<Course>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return courses;
    }

    public List<Study_Class> showTimetable(Timestamp ts1, Timestamp ts2, Course course)
    {
        String s1 = "SELECT s FROM Study_Class s WHERE ((s.course = '" + course.getCourse_id() + "') AND (s.time >= '" + ts1 + "') AND (s.time <= '" + ts2 + "'))";
        List<Study_Class> result = (List<Study_Class>) HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1, Study_Class.class).list();
        return result;
    }
    /*void addNewCourseTeacher(Course course, Teacher teacher)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();

    }*/
}
