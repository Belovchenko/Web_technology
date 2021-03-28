package DAO;

import entities.Study_Class;
import entities.Teacher;
import entities.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HibernateSessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class TeacherDAOCoverage
{
    @Test
    public void testFindById() throws SQLException
    {
        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher = TeacherManage.findById(1);
        Assert.assertEquals(teacher.getTeacher_id() , 1);
    }

    @Test
    public void testAddTeacher() throws SQLException
    {
        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher  = new Teacher("Никитина Татьяна Михайловна");
        TeacherManage.addTeacher(teacher);
        Assert.assertTrue((teacher.getTeacher_id() != 0) && (TeacherManage.findById(teacher.getTeacher_id()) != null));
    }

    @Test
    public void testUpdateTeacher() throws SQLException
    {
        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher  = new Teacher("Никитина Виктория Михайловна");
        TeacherManage.addTeacher(teacher);
        teacher.setTeacher_name("NewTeacher");
        TeacherManage.updateTeacher(teacher);
        Assert.assertEquals(TeacherManage.findById(teacher.getTeacher_id()).getTeacher_name(), "NewTeacher");
    }

    @Test
    public void testDeleteTeacher() throws SQLException
    {
        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher  = new Teacher("Никитина Виктория Михайловна");
        TeacherManage.addTeacher(teacher);
        int id = teacher.getTeacher_id();
        TeacherManage.deleteTeacher(teacher);
        Assert.assertTrue(TeacherManage.findById(id) == null);
    }

    @Test
    public void testFindByCourse() throws SQLException
    {
        List<Teacher> newlist = new ArrayList<>();
        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Teacher teacher1 = TeacherManage.findById(9);
        Teacher teacher2 = TeacherManage.findById(3);
        Course course = CourseManage.findById(2);
        newlist.add(teacher1);
        newlist.add(teacher2);
        List<Teacher> list = TeacherManage.findByCourse(course);
        //System.out.println("hello1 = '" + list.get(0).getTeacher_id()+"'");
        //System.out.println("hello2 = '" + newlist.get(0).getTeacher_id()+"'");
        //System.out.println("hello3 = '" + list.get(1).getTeacher_id()+"'");
        //System.out.println("hello3 = '" + newlist.get(1).getTeacher_id()+"'");
        Assert.assertTrue(((list.get(0).getTeacher_id() == newlist.get(0).getTeacher_id()) && (list.get(1).getTeacher_id() == newlist.get(1).getTeacher_id()))
                || ((list.get(1).getTeacher_id() == newlist.get(0).getTeacher_id()) && (list.get(0).getTeacher_id() == newlist.get(1).getTeacher_id())));
    }

    @Test
    public void testShowTimetable() throws SQLException
    {
        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        //Study_Class sc = StudyManage.findById(5);
        Teacher teacher = TeacherManage.findById(3);
        List<Study_Class> list = TeacherManage.showTimetable(Timestamp.valueOf("2006-1-1 00:00:00"), Timestamp.valueOf("2008-1-1 00:00:00"), teacher);
        //System.out.println("hello= '" + list.get(1).getClass_id()+"'");
        //System.out.println("hello= '" + list.size()+"'");
        Assert.assertTrue((list.get(0).getClass_id() == 5) && (list.size() == 1));
    }
}