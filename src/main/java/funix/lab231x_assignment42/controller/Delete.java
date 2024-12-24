package funix.lab231x_assignment42.controller;

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
public class Delete {
    @Autowired
    private CourseService courseService;

    @PostMapping("/course/delete/{id}")
    public String courseDeletePost(@PathVariable("id") Long id, Model model, HttpSession session) {
       try{ courseService.delete(id);
        model.addAttribute("success", "Delete success");
        session.setAttribute("courses", courseService.findAll());
        return "Home";
       }catch (Exception e){
              model.addAttribute("error", "Delete fail!");
              return "Home";
       }
    }

    @GetMapping("/course/delete/{id}")
    public String courseDelete(@PathVariable("id") Long id, Model model, HttpSession session) {
        try {
            courseService.delete(id);
            model.addAttribute("success", "Delete success");
            session.setAttribute("courses", courseService.findAll());
            return "redirect:/Home";
        } catch (Exception e) {
            model.addAttribute("error", "Delete fail!");
            return "Home";
        }
    }
}
