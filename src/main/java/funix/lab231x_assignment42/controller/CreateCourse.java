package funix.lab231x_assignment42.controller;

import funix.lab231x_assignment42.model.Course;
import funix.lab231x_assignment42.service.CourseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreateCourse {

    @Autowired
    private CourseService courseService;

    @PostMapping("/createCourse")
    public String homePost(@RequestParam("courseName") String courseName,
                           @RequestParam("courseCode") String courseCode,
                           @RequestParam("courseAlias") String courseAlias,
                           Model model,
                           HttpSession session) {

        try {
            Course oldCourse = courseService.findByCourseCode(courseCode);
            if(oldCourse!=null){
                model.addAttribute("error", "Course code is existing, please input Course Code again");
               // session.getAttribute("courses");
                return "/Home";
            }
            Course course = new Course();
            course.setCourseName(courseName);
            course.setCourseCode(courseCode);
            course.setCourseAlias(courseAlias);
            course.setCreatedBy(session.getAttribute("username").toString());

            courseService.save(course);
            model.addAttribute("success", "Create success");
            // Load danh sách courses để hiển thị trên Home
            session.setAttribute("courses", courseService.findAll());
            return "Home";

        } catch (Exception e) {
            model.addAttribute("error", "Create fail!");
            return "Home";

        }

    }
}
