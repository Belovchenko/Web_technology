package DAO;

import entities.Course;
import entities.Teacher;

public interface CourseDAO
{
    Course findById(int id);
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
}
