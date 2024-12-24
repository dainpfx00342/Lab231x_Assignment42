package funix.lab231x_assignment42.controller;

import funix.lab231x_assignment42.model.Course;
import funix.lab231x_assignment42.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Detail {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/{id}")
    public String courseDetail(@PathVariable("id") Long id, Model model) {
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        return "courseDetail";
    }
}
