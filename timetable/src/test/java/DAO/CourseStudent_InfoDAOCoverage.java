package DAO;

import entities.Course;
import entities.CourseStudent_Info;
import entities.CourseTeacher_Info;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CourseStudent_InfoDAOCoverage {

    @Test
    public void testFindById()
    {
        CourseStudent_InfoDAOImpl CsManage = new CourseStudent_InfoDAOImpl();
        CourseStudent_Info cs = CsManage.findById(1);
        Assert.assertEquals(cs.getId(), 1);
    }

    @Test
    public void testAddCourseStudent_Info()
    {
        CourseStudent_InfoDAOImpl CsManage = new CourseStudent_InfoDAOImpl();
        CourseStudent_Info cs  = new CourseStudent_Info();
        CsManage.addCourseStudent_Info(cs);
        Assert.assertTrue((cs.getId() != 0) && (CsManage.findById(cs.getId()) != null));
    }

    @Test
    public void testUpdateCourseStudent_Info()
    {
        CourseStudent_InfoDAOImpl CsManage = new CourseStudent_InfoDAOImpl();
        CourseDAOImpl CourseManage = new CourseDAOImpl();
        CourseStudent_Info cs  = new CourseStudent_Info();
        CsManage.addCourseStudent_Info(cs);
        Course course = CourseManage.findById(1);
        cs.setCourse(course);
        CsManage.updateCourseStudent_Info(cs);
        Assert.assertEquals(CsManage.findById(cs.getId()).getCourse().getCourse_id(), 1);
    }

    @Test
    public void testDeleteCourseStudent_Info()
    {
        CourseStudent_InfoDAOImpl CsManage = new CourseStudent_InfoDAOImpl();
        CourseStudent_Info cs  = new CourseStudent_Info();
        CsManage.addCourseStudent_Info(cs);
        int id = cs.getId();
        CsManage.deleteCourseStudent_Info(cs);
        Assert.assertTrue(CsManage.findById(id) == null);
    }
}