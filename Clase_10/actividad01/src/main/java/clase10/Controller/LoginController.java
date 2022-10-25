package clase10.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @PostMapping("/landing")
    public String GetLandingPage(Model model){
        return "landing";
    }
}
    