package DAO;

import entities.Course;
import entities.Student;
import entities.Study_Class;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Teacher;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO
{
    public Teacher findById(int id)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Teacher teacher = session.get(Teacher.class, id);
        session.close();
        return teacher;
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
        //System.out.println("hello= '" + list.get(1).getClass_id()+"'");
        String s1 = "SELECT s FROM Study_Class s WHERE ((s.teacher = '" + teacher.getTeacher_id() + "') AND (s.time >= '" + ts1 + "') AND (s.time <= '" + ts2 + "'))";
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

    public List<Teacher> getAll() {
        Session session = null;
        List<Teacher> teachers = new ArrayList<Teacher>();
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Teacher> query = session.createQuery("FROM Teacher", Teacher.class);
        teachers = (List<Teacher>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return teachers;
    }
}
