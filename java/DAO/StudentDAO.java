package DAO;

import entities.Student;

import java.util.List;

public interface StudentDAO
{
    List<Student> findByGroup(int group);
    void addStudent(Student student);
    void deleteStudent(Student student);
}
