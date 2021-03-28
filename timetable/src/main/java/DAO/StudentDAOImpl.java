package DAO;

import entities.Student;
import entities.Study_Class;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Teacher;
import utils.HibernateSessionFactory;

import java.sql.Timestamp;
import java.util.List;

public class StudentDAOImpl implements StudentDAO
{
    public List<Student> findByGroup(int group)
    {
        String s1 = "from Student s where s.group_num = '" + group + "'";
        List<Student> result = (List<Student>) HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1, Student.class).list();
        return result;
    }

    public List<Student> findByStream(int stream)
    {
        String s1 = "from Student s where s.study_stream = '" + stream + "'";
        List<Student> result = (List<Student>) HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1, Student.class).list();
        return result;
    }

    public Student findById(int id)
    {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
    }

    public void addStudent(Student student)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.save(student);
        T.commit();
        session.close();
    }

    public void updateStudent(Student student)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.update(student);
        T.commit();
        session.close();
    }

    public void deleteStudent(Student student)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.delete(student);
        T.commit();
        session.close();
    }

    public List<Study_Class> showTimetable(Timestamp ts1, Timestamp ts2, Student student)
    {
        String s1 = "SELECT s FROM Study_Class s JOIN CourseStudent_Info cs ON (cs.course = s.course) WHERE ((cs.student = '"
                + student.getStudent_id() + "') AND (s.time >= '" + ts1 + "') AND (s.time <= '" + ts2 + "'))";
        List<Study_Class> result = (List<Study_Class>) HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1, Study_Class.class).list();
        return result;
    }
}
