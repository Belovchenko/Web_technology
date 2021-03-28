package DAO;

import entities.CourseStudent_Info;

public interface CourseStudent_InfoDAO
{
    CourseStudent_Info findById(int id);
    void addCourseStudent_Info(CourseStudent_Info cs_info);
    void updateCourseStudent_Info(CourseStudent_Info cs_info);
    void deleteCourseStudent_Info(CourseStudent_Info cs_info);
}
