package mvc.mvc.controller.service;

import org.springframework.stereotype.Component;

@Component
public class ApiService {
    
    public String getUserName(String email) {
        return "nombreDeUsuario";
    }
}
