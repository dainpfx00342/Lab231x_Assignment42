package funix.lab231x_assignment42.controller;

import funix.lab231x_assignment42.model.Course;
import funix.lab231x_assignment42.service.CourseService;
import funix.lab231x_assignment42.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("courses")
public class Home {

    @Autowired
    private CourseService courseService;

    @ModelAttribute("courses")
    public List<Course> courses() {
        return courseService.findAll();
    }

    @GetMapping("/Home")
    public String home() {
       return "Home";
    }




}
