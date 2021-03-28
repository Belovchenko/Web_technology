package DAO;

import entities.Course;
import entities.Student;
import entities.Study_Class;
import entities.Teacher;

import java.sql.Timestamp;
import java.util.List;

public interface TeacherDAO
{
    Teacher findById(int id);
    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
    List<Study_Class> showTimetable(Timestamp ts1, Timestamp ts2, Teacher teacher);
    List<Teacher> findByCourse(Course course);
}
