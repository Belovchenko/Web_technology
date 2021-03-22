package utils;

import entities.Auditorium;
import entities.Course;
import entities.CourseStudent_Info;
import entities.CourseTeacher_Info;
import entities.Student;
import entities.Study_Class;
import entities.Teacher;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory
{
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Auditorium.class);
                configuration.addAnnotatedClass(Course.class);
                configuration.addAnnotatedClass(CourseStudent_Info.class);
                configuration.addAnnotatedClass(CourseTeacher_Info.class);
                configuration.addAnnotatedClass(Student.class);
                configuration.addAnnotatedClass(Study_Class.class);
                configuration.addAnnotatedClass(Teacher.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        return sessionFactory;
    }
}
