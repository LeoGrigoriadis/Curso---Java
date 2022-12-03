package clase12.clase_12.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clase12.clase_12.Configuration.JwtTokenUtils;
import clase12.clase_12.Models.User;
import clase12.clase_12.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;
    @Autowired
    private JwtTokenUtils tokenUtils;

    @GetMapping("/get-all")
    public ResponseEntity<?> getUsers(@RequestHeader("token") String token){
        HashMap<String, Object> responseMap = new HashMap<>();
        try{
            if(!tokenUtils.validateToken(token)){
                responseMap.put("error", true);
                responseMap.put("message", "ERROR: No estás autorizado para acceder a este recurso");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMap);
            } 
            Iterable<User> users = userService.getUsers();
            responseMap.put("error", false);
            responseMap.put("users", users);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMap);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR: Not Found Exception.");
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id, @RequestHeader("token") String token){
        try{
            boolean isTokenValid = tokenUtils.validateToken(token);
            if(!isTokenValid){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("ERROR: No estás autorizado para acceder a este recurso.");
            }
            User users = userService.getUser(id);
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR: Not Found Exception.");
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User newUser){
        boolean isSave = userService.save(newUser);
        if(isSave){ return ResponseEntity.status(HttpStatus.CREATED).body("OK: El usuario fue creado con éxito.");
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR: El usuario no se pudo crear.");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User newUser){
        boolean isUpdate = userService.update(newUser);
        if(isUpdate){ return ResponseEntity.status(HttpStatus.OK).body("OK: El usuario fue modificado con éxito.");
        } return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR: El usuario no se pudo modificar.");
    }
}
