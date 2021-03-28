package DAO;

import entities.Course;
import entities.Student;
import entities.Study_Class;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Teacher;
import utils.HibernateSessionFactory;

import java.sql.Timestamp;
import java.util.List;

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

    public void updateTeacher(Teacher teacher)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.update(teacher);
        T.commit();
        session.close();
    }

    public void deleteTeacher(Teacher teacher)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.delete(teacher);
        T.commit();
        session.close();
    }

    public List<Study_Class> showTimetable(Timestamp ts1, Timestamp ts2, Teacher teacher)
    {
        String s1 = "SELECT s FROM Study_Class s JOIN CourseTeacher_Info ct ON (ct.course = s.course) WHERE ((ct.teacher = '"
                + teacher.getTeacher_id() + "') AND (s.time >= '" + ts1 + "') AND (s.time <= '" + ts2 + "'))";
        List<Study_Class> result = (List<Study_Class>) HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1, Study_Class.class).list();
        return result;
    }

    public List<Teacher> findByCourse(Course course)
    {
        String s1 = "SELECT t FROM Teacher t JOIN CourseTeacher_Info ct ON (ct.teacher = t) WHERE (ct.course = '"
                + course.getCourse_id() + "')";
        List<Teacher> result = (List<Teacher>) HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1, Teacher.class).list();
        return result;
    }
}
