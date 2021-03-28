package DAO;

import entities.Course;
import entities.Student;
import entities.Study_Class;
import entities.Teacher;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class StudentDAOCoverage {

    @Test
    public void testFindByGroup()
    {
        List<Student> newlist = new ArrayList<>();
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student1 = StudentManage.findById(5);
        Student student2 = StudentManage.findById(6);
        newlist.add(student1);
        newlist.add(student2);
        List<Student> list = StudentManage.findByGroup(202);
        Assert.assertTrue( (newlist.size() == list.size()) && (((list.get(0).getStudent_id() == newlist.get(0).getStudent_id()) && (list.get(1).getStudent_id() == newlist.get(1).getStudent_id()))
                || ((list.get(1).getStudent_id() == newlist.get(0).getStudent_id()) && (list.get(0).getStudent_id() == newlist.get(1).getStudent_id()))));
    }

    @Test
    public void testFindByStream()
    {
        List<Student> newlist = new ArrayList<>();
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student1 = StudentManage.findById(9);
        Student student2 = StudentManage.findById(10);
        newlist.add(student1);
        newlist.add(student2);
        List<Student> list = StudentManage.findByStream(2);
        Assert.assertTrue( (newlist.size() == list.size()) && (((list.get(0).getStudent_id() == newlist.get(0).getStudent_id()) && (list.get(1).getStudent_id() == newlist.get(1).getStudent_id()))
                || ((list.get(1).getStudent_id() == newlist.get(0).getStudent_id()) && (list.get(0).getStudent_id() == newlist.get(1).getStudent_id()))));
    }

    @Test
    public void testFindById()
    {
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student = StudentManage.findById(1);
        Assert.assertEquals(student.getStudent_id() , 1);
    }

    @Test
    public void testAddStudent()
    {
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student  = new Student("Землянский Евгений Романович", 2000, 141, 1);
        StudentManage.addStudent(student);
        Assert.assertTrue((student.getStudent_id() != 0) && (StudentManage.findById(student.getStudent_id()) != null));
    }

    @Test
    public void testUpdateStudent()
    {
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student  = new Student("Землянский Евгений Романович", 2001, 141, 1);
        StudentManage.addStudent(student);
        student.setStudent_group(101);
        StudentManage.updateStudent(student);
        Assert.assertEquals(StudentManage.findById(student.getStudent_id()).getStudent_group(), 101);
    }

    @Test
    public void testDeleteStudent()
    {
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student  = new Student("Землянский Евгений Романович", 2002, 141, 1);
        StudentManage.addStudent(student);
        int id = student.getStudent_id();
        StudentManage.deleteStudent(student);
        Assert.assertTrue(StudentManage.findById(id) == null);
    }

    @Test
    public void testShowTimetable()
    {
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student = StudentManage.findById(2);
        List<Study_Class> list = StudentManage.showTimetable(Timestamp.valueOf("2002-1-1 00:00:00"), Timestamp.valueOf("2004-1-1 00:00:00"), student);
        Assert.assertTrue((list.get(0).getClass_id() == 3) && (list.size() == 1));
    }
}