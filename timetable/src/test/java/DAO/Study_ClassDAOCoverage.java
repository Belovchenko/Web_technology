package DAO;

import entities.Auditorium;
import entities.Course;
import entities.CourseStudent_Info;
import entities.Study_Class;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;

import static org.testng.Assert.*;

public class Study_ClassDAOCoverage {

    @Test
    public void testFindById()
    {
        Study_ClassDAOImpl ScManage = new Study_ClassDAOImpl();
        Study_Class sc = ScManage.findById(1);
        Assert.assertEquals(sc.getClass_id(), 1);
    }

    @Test
    public void testAddStudy_Class()
    {
        Study_ClassDAOImpl ScManage = new Study_ClassDAOImpl();
        Study_Class sc = new Study_Class();
        ScManage.addStudy_Class(sc);
        Assert.assertTrue((sc.getClass_id() != 0) && (ScManage.findById(sc.getClass_id()) != null));
    }

    @Test
    public void testUpdateStudy_Class()
    {
        Study_ClassDAOImpl ScManage = new Study_ClassDAOImpl();
        Study_Class sc = new Study_Class();
        ScManage.addStudy_Class(sc);
        sc.setTime(Timestamp.valueOf("2010-07-03 08:45:00"));
        ScManage.updateStudy_Class(sc);
        Assert.assertEquals(ScManage.findById(sc.getClass_id()).getTime(), Timestamp.valueOf("2010-07-03 08:45:00"));
    }

    @Test
    public void testDeleteStudy_Class()
    {
        Study_ClassDAOImpl ScManage = new Study_ClassDAOImpl();
        Study_Class sc = new Study_Class();
        ScManage.addStudy_Class(sc);
        int id = sc.getClass_id();
        ScManage.deleteStudy_Class(sc);
        Assert.assertTrue(ScManage.findById(id) == null);
    }
}