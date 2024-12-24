package funix.lab231x_assignment42.controller;

import funix.lab231x_assignment42.model.Course;
import funix.lab231x_assignment42.service.CourseService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Edit {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course/edit/{id}")
    public String courseEdit(@PathVariable("id") Long id, Model model) {
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        return "editCourse";
    }

    @PostMapping("/course/edit/{id}")
    public String courseEditPost(@PathVariable("id") Long id,
                                 @RequestParam("courseName") String courseName,
                                 @RequestParam("courseCode") String courseCode,
                                 @RequestParam("courseAlias") String courseAlias,
                                 @RequestParam("courseStatus") boolean courseStatus,
                                 Model model,
                                 HttpSession session) {
        Course oldCourse = courseService.findByCourseCode(courseCode);
        if(oldCourse!=null){
            model.addAttribute("course", oldCourse);
            model.addAttribute("error", "Course code is existing, please input Course Code again");
            return "editCourse";
        }

        Course course = courseService.findById(id);
        String updateBy = session.getAttribute("username").toString();
        course.setCourseName(courseName);
        course.setCourseCode(courseCode);
        course.setCourseAlias(courseAlias);
        course.setUpdatedBy(updateBy);
        course.setCourseStatus(courseStatus);
        courseService.save(course);
        session.setAttribute("courses", courseService.findAll());
        model.addAttribute("success", "Update "+courseName+" success");
        return "Home";
    }

}
