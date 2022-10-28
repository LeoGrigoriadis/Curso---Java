package clase11.clase_11.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import clase11.clase_11.Repositories.PersonaRepository;

@Controller
public class PersonaController {
    
    @Autowired
    PersonaRepository personaRepository;
}
