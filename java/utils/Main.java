package utils;

import DAO.StudentDAOImpl;
import entities.Teacher;
import entities.Student;
import DAO.TeacherDAOImpl;
import java.sql.SQLException;
import java.util.List;

public class Main
{
    public static void printList(List<Student> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) throws SQLException {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Teacher teacher = new Teacher("Teacher");
        TeacherManage.addTeacher(teacher);
        Teacher teacher1 = new Teacher("New Teacher");
        TeacherManage.addTeacher(teacher1);
        Teacher teacher2 = new Teacher("Newest Teacher");
        TeacherManage.addTeacher(teacher2);
        TeacherManage.deleteTeacher(teacher1);
        printList(StudentManage.findByGroup(301));
    }
}
