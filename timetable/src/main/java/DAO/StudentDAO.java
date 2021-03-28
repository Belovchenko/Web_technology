package DAO;

import entities.Student;
import entities.Study_Class;
import entities.Teacher;

import java.sql.Timestamp;
import java.util.List;

public interface StudentDAO
{
    List<Student> findByStream(int stream);
    List<Student> findByGroup(int group);
    List<Study_Class> showTimetable(Timestamp ts1, Timestamp ts2, Student student);
    Student findById(int id);
    void updateStudent(Student student);
    void addStudent(Student student);
    void deleteStudent(Student student);
}
