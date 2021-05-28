package DAO;

import entities.Auditorium;
import entities.Student;
import entities.Study_Class;
import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AuditoriumDAOImpl implements AuditoriumDAO
{
    public Auditorium findByNum(int num)
    {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Auditorium.class, num);
    }

    public void addAuditorium(Auditorium auditorium)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.save(auditorium);
        T.commit();
        session.close();
    }

    public void updateAuditorium(Auditorium auditorium)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.update(auditorium);
        T.commit();
        session.close();
    }

    public void deleteAuditorium(Auditorium auditorium)
    {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction T = session.beginTransaction();
        session.delete(auditorium);
        T.commit();
        session.close();
    }

    public List<Auditorium> showFreeAuditoriums(Timestamp ts1, Timestamp ts2)
    {
        //Timestamp duration = Timestamp.valueOf("0000-00-00 01:30:00");
        String s1 = "SELECT DISTINCT a FROM Study_Class s RIGHT JOIN Auditorium a ON (a = s.auditorium) WHERE ((s.time <= '" + ts1 + "') OR (s.time >= '" + ts2 + "') OR (s.time = NULL)) ORDER BY a.auditorium_num";
        List<Auditorium> result = (List<Auditorium>) HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1, Auditorium.class).list();
        return result;
    }

    public List<Auditorium> getAll() {
        Session session = null;
        List<Auditorium> Auditoriums = new ArrayList<Auditorium>();
        session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query<Auditorium> query = session.createQuery("FROM Auditorium", Auditorium.class);
        Auditoriums = (List<Auditorium>) query.list();
        session.getTransaction().commit();
        if (session != null && session.isOpen()) {
            session.close();
        }
        return Auditoriums;
    }

    public List<Study_Class> showTimetable(Timestamp ts1, Timestamp ts2, Auditorium auditorium)
    {
        String s1 = "SELECT s FROM Study_Class s WHERE ((s.auditorium = '" + auditorium.getAuditorium_num() + "') AND (s.time >= '" + ts1 + "') AND (s.time <= '" + ts2 + "'))";
        List<Study_Class> result = (List<Study_Class>) HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1, Study_Class.class).list();
        return result;
    }


}
