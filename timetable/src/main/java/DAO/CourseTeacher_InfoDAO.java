package DAO;

import entities.CourseTeacher_Info;

public interface CourseTeacher_InfoDAO
{
    CourseTeacher_Info findById(int id);
    void addCourseTeacher_Info(CourseTeacher_Info ct_info);
    void updateCourseTeacher_Info(CourseTeacher_Info ct_info);
    void deleteCourseTeacher_Info(CourseTeacher_Info ct_info);
}
