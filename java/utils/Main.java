package utils;

import entities.Teacher;
import DAO.TeacherDAOImpl;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher = new Teacher("Teacher");
        TeacherManage.addTeacher(teacher);
        Teacher teacher1 = new Teacher("New Teacher");
        TeacherManage.addTeacher(teacher1);
        Teacher teacher2 = new Teacher("Newest Teacher");
        TeacherManage.addTeacher(teacher2);
        TeacherManage.deleteTeacher(teacher1);
    }
}
