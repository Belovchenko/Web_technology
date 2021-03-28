package DAO;

import entities.Auditorium;
import entities.Study_Class;
import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.sql.Timestamp;
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
        String s1 = "SELECT a FROM Study_Class s RIGHT JOIN Auditorium a ON (a = s.auditorium) WHERE ((s.time <= '" + ts1 + "') OR (s.time >= '" + ts2 + "') OR (s.time = NULL))";
        List<Auditorium> result = (List<Auditorium>) HibernateSessionFactory.getSessionFactory().openSession().createQuery(s1, Auditorium.class).list();
        return result;
    }


}
