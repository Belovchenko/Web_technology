package DAO;

import entities.Teacher;

public interface TeacherDAO
{
    Teacher findById(int id);
    void addTeacher(Teacher teacher);
    //void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
}
