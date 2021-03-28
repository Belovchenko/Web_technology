package DAO;

import entities.Course;
import entities.CourseTeacher_Info;
import entities.Teacher;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CourseTeacher_InfoDAOCoverage {

    @Test
    public void testFindById()
    {
        CourseTeacher_InfoDAOImpl CtManage = new CourseTeacher_InfoDAOImpl();
        CourseTeacher_Info ct = CtManage.findById(1);
        Assert.assertEquals(ct.getId(), 1);
    }

    @Test
    public void testAddCourseTeacher_Info()
    {
        CourseTeacher_InfoDAOImpl CtManage = new CourseTeacher_InfoDAOImpl();
        CourseTeacher_Info ct  = new CourseTeacher_Info();
        CtManage.addCourseTeacher_Info(ct);
        Assert.assertTrue((ct.getId() != 0) && (CtManage.findById(ct.getId()) != null));
    }

    @Test
    public void testUpdateCourseTeacher_Info()
    {
        CourseTeacher_InfoDAOImpl CtManage = new CourseTeacher_InfoDAOImpl();
        CourseDAOImpl CourseManage = new CourseDAOImpl();
        CourseTeacher_Info ct  = new CourseTeacher_Info();
        CtManage.addCourseTeacher_Info(ct);
        Course course = CourseManage.findById(1);
        ct.setCourse(course);
        CtManage.updateCourseTeacher_Info(ct);
        Assert.assertEquals(CtManage.findById(ct.getId()).getCourse().getCourse_id(), 1);
    }

    @Test
    public void testDeleteCourseTeacher_Info()
    {
        CourseTeacher_InfoDAOImpl CtManage = new CourseTeacher_InfoDAOImpl();
        CourseTeacher_Info ct  = new CourseTeacher_Info();
        CtManage.addCourseTeacher_Info(ct);
        int id = ct.getId();
        CtManage.deleteCourseTeacher_Info(ct);
        Assert.assertTrue(CtManage.findById(id) == null);
    }
}