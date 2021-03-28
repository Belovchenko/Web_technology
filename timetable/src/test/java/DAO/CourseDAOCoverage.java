package DAO;

import entities.Course;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CourseDAOCoverage {

    @Test
    public void testFindById()
    {
        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Course course = CourseManage.findById(1);
        Assert.assertEquals(course.getCourse_id(), 1);
    }

    @Test
    public void testAddCourse()
    {
        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Course course  = new Course("Дискретная математика", 1, 2000);
        CourseManage.addCourse(course);
        Assert.assertTrue((course.getCourse_id() != 0) && (CourseManage.findById(course.getCourse_id()) != null));
    }

    @Test
    public void testUpdateCourse()
    {
        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Course course  = new Course("Дискретная математика", 2, 2001);
        CourseManage.addCourse(course);
        course.setYear(2005);
        CourseManage.updateCourse(course);
        Assert.assertEquals(CourseManage.findById(course.getCourse_id()).getYear(), 2005);
    }

    @Test
    public void testDeleteCourse()
    {
        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Course course  = new Course("Дискретная математика", 2, 2002);
        CourseManage.addCourse(course);
        int id = course.getCourse_id();
        CourseManage.deleteCourse(course);
        Assert.assertTrue(CourseManage.findById(id) == null);
    }
}