package clase12.clase_12.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import clase12.clase_12.Services.CancionService;

@RestController
public class CancionController {
    
    @Autowired
    CancionService cancionService;
}
