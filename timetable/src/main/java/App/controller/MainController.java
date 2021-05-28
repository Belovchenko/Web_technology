package App.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DAO.*;
import entities.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class MainController {

    /*private static TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
    private static List<Teacher> teachers = new ArrayList<Teacher>();
    static {
        teachers = TeacherManage.getAll();
    }*/

    @RequestMapping(value = { "/", "/students"}, method = RequestMethod.GET)
    public String students(Model model) {

        //String message = "Spring Boot and JSP controller";

        //model.addAttribute("message", message);

        StudentDAOImpl StudentManage = new StudentDAOImpl();
        List<Student> students = new ArrayList<Student>();
        students = StudentManage.getAll();
        model.addAttribute("students", students);

        return "students";
    }

    @RequestMapping(value = { "/addStudent" }, method = RequestMethod.POST)
    public String addStudent(WebRequest webRequest) {

        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student = new Student(webRequest.getParameter("name"), Integer.parseInt(webRequest.getParameter("year")), Integer.parseInt(webRequest.getParameter("group")), Integer.parseInt(webRequest.getParameter("stream")));
        StudentManage.addStudent(student);

        return "redirect:students";
    }

    @RequestMapping(value = {"/addStudent"}, method = RequestMethod.GET)
    public String addStudent(Model model){
        return "addStudent";
    }

    @RequestMapping(value = { "/student" }, method = RequestMethod.GET)
    public String student(@RequestParam int student_id, Model model) {

        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student = StudentManage.findById(student_id);
        model.addAttribute("student", student);

        return "student";
    }

    @RequestMapping(value = { "/deleteStudent" }, method = RequestMethod.POST)
    public String deleteStudent(@RequestParam int student_id, Model model) {

        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student = StudentManage.findById(student_id);
        StudentManage.deleteStudent(student);

        return "redirect:students";
    }

    @RequestMapping(value = { "/Schedule" }, method = RequestMethod.GET)
    public String Schedule(WebRequest webRequest, Model model) {

        StudentDAOImpl StudentManage = new StudentDAOImpl();
        List<Study_Class> schedule = new ArrayList<Study_Class>();
        LocalDateTime localDateTime1 = LocalDateTime.parse(webRequest.getParameter("timestamp1"));
        LocalDateTime localDateTime2 = LocalDateTime.parse(webRequest.getParameter("timestamp2"));
        schedule = StudentManage.showTimetable(Timestamp.valueOf(localDateTime1), Timestamp.valueOf(localDateTime2), StudentManage.findById(Integer.parseInt(webRequest.getParameter("student"))));
        model.addAttribute("schedule", schedule);

        return "Schedule";
    }

    @RequestMapping(value = { "/editStudent" }, method = RequestMethod.GET)
    public String editStudent(WebRequest webRequest, Model model) {

        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student = StudentManage.findById(Integer.parseInt(webRequest.getParameter("student")));
        model.addAttribute("student", student);

        return "editStudent";
    }

    @RequestMapping(value = { "/editStudent" }, method = RequestMethod.POST)
    public String editStudent(@RequestParam int student_id, WebRequest webRequest, Model model) {

        StudentDAOImpl StudentManage = new StudentDAOImpl();
        Student student = StudentManage.findById(student_id);
        student.setStudent_name(webRequest.getParameter("name"));
        student.setStudent_year(Integer.parseInt(webRequest.getParameter("year")));
        student.setStudent_stream(Integer.parseInt(webRequest.getParameter("stream")));
        student.setStudent_group(Integer.parseInt(webRequest.getParameter("group")));
        StudentManage.updateStudent(student);

        return "redirect:/students";
    }

    @RequestMapping(value = { "/teachers" }, method = RequestMethod.GET)
    public String teachers(Model model) {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers = TeacherManage.getAll();
        model.addAttribute("teachers", teachers);

        /*CourseTeacher_InfoDAOImpl CtManage = new CourseTeacher_InfoDAOImpl();
        List<CourseTeacher_Info> ct_info = new ArrayList<CourseTeacher_Info>();
        ct_info = CtManage.getAll();
        model.addAttribute("ct_info", ct_info);*/

        return "teachers";
    }

    @RequestMapping(value = { "/addTeacher" }, method = RequestMethod.POST)
    public String addTeacher(WebRequest webRequest) {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher = new Teacher(webRequest.getParameter("name"));
        TeacherManage.addTeacher(teacher);

        return "redirect:teachers";
    }

    @RequestMapping(value = {"/addTeacher"}, method = RequestMethod.GET)
    public String addTeacher(Model model){
        return "addTeacher";
    }

    @RequestMapping(value = { "/teacher" }, method = RequestMethod.GET)
    public String teacher(@RequestParam int teacher_id, Model model) {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher = TeacherManage.findById(teacher_id);
        model.addAttribute("teacher", teacher);

        return "teacher";
    }

    @RequestMapping(value = { "/deleteTeacher" }, method = RequestMethod.POST)
    public String deleteTeacher(@RequestParam int teacher_id, Model model) {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher = TeacherManage.findById(teacher_id);
        TeacherManage.deleteTeacher(teacher);

        return "redirect:teachers";
    }

    @RequestMapping(value = { "/tSchedule" }, method = RequestMethod.GET)
    public String tSchedule(WebRequest webRequest, Model model) {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        List<Study_Class> schedule = new ArrayList<Study_Class>();
        LocalDateTime localDateTime1 = LocalDateTime.parse(webRequest.getParameter("timestamp1"));
        LocalDateTime localDateTime2 = LocalDateTime.parse(webRequest.getParameter("timestamp2"));
        schedule = TeacherManage.showTimetable(Timestamp.valueOf(localDateTime1), Timestamp.valueOf(localDateTime2), TeacherManage.findById(Integer.parseInt(webRequest.getParameter("teacher"))));
        model.addAttribute("schedule", schedule);

        return "tSchedule";
    }

    @RequestMapping(value = { "/editTeacher" }, method = RequestMethod.GET)
    public String editTeacher(WebRequest webRequest, Model model) {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher = TeacherManage.findById(Integer.parseInt(webRequest.getParameter("teacher")));
        model.addAttribute("teacher", teacher);

        return "editTeacher";
    }

    @RequestMapping(value = { "/editTeacher" }, method = RequestMethod.POST)
    public String editTeacher(@RequestParam int teacher_id, WebRequest webRequest, Model model) {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        Teacher teacher = TeacherManage.findById(teacher_id);
        teacher.setTeacher_name(webRequest.getParameter("name"));
        TeacherManage.updateTeacher(teacher);

        return "redirect:/teachers";
    }

    @RequestMapping(value = { "/courses" }, method = RequestMethod.GET)
    public String courses(Model model) {

        CourseDAOImpl CourseManage = new CourseDAOImpl();
        List<Course> courses = new ArrayList<Course>();
        courses = CourseManage.getAll();
        model.addAttribute("courses", courses);

        return "courses";
    }

    @RequestMapping(value = { "/auditoriums" }, method = RequestMethod.GET)
    public String auditoriums(Model model) {

        AuditoriumDAOImpl AudManage = new AuditoriumDAOImpl();
        List<Auditorium> auditoriums = new ArrayList<Auditorium>();
        auditoriums = AudManage.getAll();
        model.addAttribute("auditoriums", auditoriums);

        return "auditoriums";
    }

    @RequestMapping(value = { "/free_auditoriums" }, method = RequestMethod.GET)
    public String FreeAuditoriums(WebRequest webRequest, Model model) {

        AuditoriumDAOImpl AudManage = new AuditoriumDAOImpl();
        List<Auditorium> auditoriums = new ArrayList<Auditorium>();
        LocalDateTime localDateTime1 = LocalDateTime.parse(webRequest.getParameter("timestamp1"));
        LocalDateTime localDateTime2 = LocalDateTime.parse(webRequest.getParameter("timestamp2"));
        auditoriums = AudManage.showFreeAuditoriums(Timestamp.valueOf(localDateTime1), Timestamp.valueOf(localDateTime2));
        model.addAttribute("auditoriums", auditoriums);

        return "auditoriums";
    }

    @RequestMapping(value = { "/auditorium" }, method = RequestMethod.GET)
    public String auditoriums(@RequestParam int auditorium_num, Model model) {

        AuditoriumDAOImpl AudManage = new AuditoriumDAOImpl();
        Auditorium auditorium = AudManage.findByNum(auditorium_num);
        model.addAttribute("auditorium", auditorium);

        return "auditorium";
    }

    @RequestMapping(value = { "/aSchedule" }, method = RequestMethod.GET)
    public String auditoriumSchedule(WebRequest webRequest, Model model) {

        AuditoriumDAOImpl AudManage = new AuditoriumDAOImpl();
        Study_ClassDAOImpl ScManage = new Study_ClassDAOImpl();
        List<Study_Class> schedule = new ArrayList<Study_Class>();
        LocalDateTime localDateTime1 = LocalDateTime.parse(webRequest.getParameter("timestamp1"));
        LocalDateTime localDateTime2 = LocalDateTime.parse(webRequest.getParameter("timestamp2"));
        schedule = AudManage.showTimetable(Timestamp.valueOf(localDateTime1), Timestamp.valueOf(localDateTime2), AudManage.findByNum(Integer.parseInt(webRequest.getParameter("auditorium"))));
        model.addAttribute("schedule", schedule);

        return "aSchedule";
    }

    @RequestMapping(value = { "/course" }, method = RequestMethod.GET)
    public String course(@RequestParam int course_id, Model model) {

        CourseStudent_InfoDAOImpl CsManage = new CourseStudent_InfoDAOImpl();
        List<CourseStudent_Info> cs_info = new ArrayList<CourseStudent_Info>();
        cs_info = CsManage.getAll();
        model.addAttribute("cs_info", cs_info);

        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Course course = CourseManage.findById(course_id);
        model.addAttribute("course", course);

        return "course";
    }

    @RequestMapping(value = { "/addCourse" }, method = RequestMethod.POST)
    public String addCourse(WebRequest webRequest) {

        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        CourseTeacher_InfoDAOImpl CtManage = new CourseTeacher_InfoDAOImpl();
        CourseStudent_InfoDAOImpl CsManage = new CourseStudent_InfoDAOImpl();

        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Course course = new Course(webRequest.getParameter("name"), 1, Integer.parseInt(webRequest.getParameter("year")));

        String teacherstr = webRequest.getParameter("teachers");
        String studentstr = webRequest.getParameter("students");

        if (teacherstr != null)
        {
            String[] teachers = teacherstr.split(" ");
            for(int i = 0; i <= teachers.length - 1; i++)
            {
                CourseTeacher_Info ct_info = new CourseTeacher_Info(course, TeacherManage.findById(Integer.parseInt(teachers[i])));
                CtManage.addCourseTeacher_Info(ct_info);
                course.getCourse_teacher_info().add(ct_info);
            }
        }

        if (studentstr != null)
        {
            String[] students = studentstr.split(" ");
            for(int i = 0; i <= students.length - 1; i++)
            {
                CourseStudent_Info cs_info = new CourseStudent_Info(course, StudentManage.findById(Integer.parseInt(students[i])));
                CsManage.addCourseStudent_Info(cs_info);
                course.getCourse_student_info().add(cs_info);
            }
        }

        return "redirect:courses";
    }

    @RequestMapping(value = {"/addCourse"}, method = RequestMethod.GET)
    public String addCourse(Model model){
        return "addCourse";
    }

    @RequestMapping(value = { "/deleteCourse" }, method = RequestMethod.POST)
    public String deleteCourse(@RequestParam int course_id, Model model) {

        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Course course = CourseManage.findById(course_id);
        CourseManage.deleteCourse(course);

        return "redirect:courses";
    }

    @RequestMapping(value = { "/cSchedule" }, method = RequestMethod.GET)
    public String cSchedule(WebRequest webRequest, Model model) {

        CourseDAOImpl CourseManage = new CourseDAOImpl();
        List<Study_Class> schedule = new ArrayList<Study_Class>();
        LocalDateTime localDateTime1 = LocalDateTime.parse(webRequest.getParameter("timestamp1"));
        LocalDateTime localDateTime2 = LocalDateTime.parse(webRequest.getParameter("timestamp2"));
        schedule = CourseManage.showTimetable(Timestamp.valueOf(localDateTime1), Timestamp.valueOf(localDateTime2), CourseManage.findById(Integer.parseInt(webRequest.getParameter("course"))));
        model.addAttribute("schedule", schedule);

        return "cSchedule";
    }

    @RequestMapping(value = { "/editCourse" }, method = RequestMethod.GET)
    public String editCourse(WebRequest webRequest, Model model) {

        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Course course = CourseManage.findById(Integer.parseInt(webRequest.getParameter("course")));
        model.addAttribute("course", course);

        String students = "";
        List<CourseStudent_Info> studentList = new ArrayList<>(course.getCourse_student_info());
        for(int i = 0; i <= studentList.size() - 1; i++)
        {
            students += studentList.get(i).getStudent().getStudent_id();
            if (i != studentList.size() - 1) students += " ";
        }

        String teachers = "";
        List<CourseTeacher_Info> teacherList = new ArrayList<>(course.getCourse_teacher_info());
        for(int i = 0; i <= teacherList.size() - 1; i++)
        {
            teachers += teacherList.get(i).getTeacher().getTeacher_id();
            if (i != teacherList.size() - 1) teachers += " ";
        }

        model.addAttribute("students", students);
        model.addAttribute("teachers", teachers);

        return "editCourse";
    }

    @RequestMapping(value = { "/editCourse" }, method = RequestMethod.POST)
    public String editCourse(@RequestParam int course_id, WebRequest webRequest, Model model) {

        CourseDAOImpl CourseManage = new CourseDAOImpl();
        StudentDAOImpl StudentManage = new StudentDAOImpl();
        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        CourseStudent_InfoDAOImpl CsManage = new CourseStudent_InfoDAOImpl();
        CourseTeacher_InfoDAOImpl CtManage = new CourseTeacher_InfoDAOImpl();
        Course course = CourseManage.findById(course_id);
        model.addAttribute("course", course);

        course.setCourse_name(webRequest.getParameter("name"));
        course.setYear(Integer.parseInt(webRequest.getParameter("year")));

        String students = webRequest.getParameter("students");
        String teachers = webRequest.getParameter("teachers");

        List<CourseStudent_Info> studentList = new ArrayList<>(course.getCourse_student_info());
        for(int i = 0; i <= studentList.size() - 1; i++)
        {
            CsManage.deleteCourseStudent_Info(studentList.get(i));
        }

        List<CourseTeacher_Info> teacherList = new ArrayList<>(course.getCourse_teacher_info());
        for(int i = 0; i <= teacherList.size() - 1; i++)
        {
            CtManage.deleteCourseTeacher_Info(teacherList.get(i));
        }

        String[] newstudents = students.split(" ");
        String[] newteachers = teachers.split(" ");
        Set<CourseStudent_Info> studentSet = new HashSet<>();
        Set<CourseTeacher_Info> teacherSet = new HashSet<>();
        CourseStudent_Info cs;
        CourseTeacher_Info ct;

        for(int i = 0; i <= newstudents.length - 1; i++)
        {
            cs = new CourseStudent_Info(CourseManage.findById(course_id), StudentManage.findById(Integer.parseInt(newstudents[i])));
            CsManage.addCourseStudent_Info(cs);
            studentSet.add(cs);
        }

        for(int i = 0; i <= newteachers.length - 1; i++)
        {
            ct = new CourseTeacher_Info(CourseManage.findById(course_id), TeacherManage.findById(Integer.parseInt(newteachers[i])));
            CtManage.addCourseTeacher_Info(ct);
            teacherSet.add(ct);
        }

        course.setCourse_student_info(studentSet);
        course.setCourse_teacher_info(teacherSet);

        return "redirect:/courses";
    }

    @RequestMapping(value = { "/editSchedule" }, method = RequestMethod.GET)
    public String editSchedule(WebRequest webRequest, Model model) {

        CourseDAOImpl CourseManage = new CourseDAOImpl();
        Course course = CourseManage.findById(Integer.parseInt(webRequest.getParameter("course")));
        model.addAttribute("course", course);
        return "editSchedule";
    }

    @RequestMapping(value = { "/editSchedule" }, method = RequestMethod.POST)
    public String editSchedule(@RequestParam int course_id, WebRequest webRequest, Model model) {

        Study_ClassDAOImpl ScManage = new Study_ClassDAOImpl();
        CourseDAOImpl CourseManage = new CourseDAOImpl();
        TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
        AuditoriumDAOImpl AudManage = new AuditoriumDAOImpl();
        Study_Class sc = new Study_Class(CourseManage.findById(course_id), TeacherManage.findById(Integer.parseInt(webRequest.getParameter("teacher"))), AudManage.findByNum(Integer.parseInt(webRequest.getParameter("aud"))), Timestamp.valueOf(LocalDateTime.parse(webRequest.getParameter("timestamp1"))));
        ScManage.addStudy_Class(sc);

        return "/editSchedule";
    }
}
