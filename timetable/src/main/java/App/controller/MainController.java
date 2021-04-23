package App.controller;

import java.util.ArrayList;
import java.util.List;

import DAO.TeacherDAOImpl;
import entities.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    private static TeacherDAOImpl TeacherManage = new TeacherDAOImpl();
    private static List<Teacher> teachers = new ArrayList<Teacher>();
    static {
        teachers = TeacherManage.getAll();
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Spring Boot and JSP controller";

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/teacherList" }, method = RequestMethod.GET)
    public String viewTeacherList(Model model) {

        model.addAttribute("teachers", teachers);

        return "teacherList";
    }

}
