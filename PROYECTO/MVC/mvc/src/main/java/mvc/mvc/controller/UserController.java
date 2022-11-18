package mvc.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import mvc.mvc.controller.service.ApiService;

public class UserController {
    
    @Autowired
    private ApiService api;

    //@PreAuthorize("")
    //@RolesAllowed("ROLE_USER")     esta anotation viene de la mano de poner true a las anotaciones de jsr250
    public String createUserForm() {
        return "formUser";
    }

    @Secured({ "ROLE_USER", "ROLE_ADMIN" })
    public boolean isValidUsername(String email) {
        String temp = api.getUserName(email);
        if(temp != null) {
            return false;
        }
        return true;
    }
    
}
