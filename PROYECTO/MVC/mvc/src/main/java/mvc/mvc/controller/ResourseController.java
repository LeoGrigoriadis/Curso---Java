package mvc.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourseController {
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
 
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    
}
