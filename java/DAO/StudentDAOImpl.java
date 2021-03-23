package DAO;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Teacher;
import utils.HibernateSessionFactory;

import java.util.List;

public class StudentDAOImpl implements StudentDAO
{
    public List<Student> findByGroup(int group)
    {
        String s1 = "from Student s where s.group_num = '" + group + "'";
        List<Student> result = (List<Student>)  HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1).list();
        return result;
    }

    public void addStudent(Student student)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.save(student);
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
}
