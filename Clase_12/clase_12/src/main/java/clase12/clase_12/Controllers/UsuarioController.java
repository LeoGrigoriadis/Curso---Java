package clase12.clase_12.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import clase12.clase_12.Models.Usuario;
import clase12.clase_12.Services.UsuarioService;

@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/api/get-users")
    public ResponseEntity<?> getUsers(){
        try{
            Iterable<Usuario> usuarios = usuarioService.getUsers();
            return ResponseEntity.status(200).body(usuarios);
        }catch(Exception e){
            return ResponseEntity.status(404).body("ERROR: Not Found Exception.");
        }
    }

    @GetMapping("/api/get-user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        try{
            Usuario usuarios = usuarioService.getUser(id);
            return ResponseEntity.status(200).body(usuarios);
        }catch(Exception e){
            return ResponseEntity.status(404).body("ERROR: Not Found Exception.");
        }
    }

    @PostMapping("/api/save-user")
    public ResponseEntity<?> saveUser(@RequestBody Usuario nuevoUsuario){
        boolean isSave = usuarioService.save(nuevoUsuario);
        if(isSave){ return ResponseEntity.status(201).body("OK: El usuario fue creado con éxito.");
        } return ResponseEntity.status(404).body("ERROR: El usuario no se pudo crear.");
    }

    @PutMapping("/api/update-user")
    public ResponseEntity<?> updateUser(@RequestBody Usuario nuevoUsuario){
        boolean isUpdate = usuarioService.update(nuevoUsuario);
        if(isUpdate){ return ResponseEntity.status(200).body("OK: El usuario fue modificado con éxito.");
        } return ResponseEntity.status(404).body("ERROR: El usuario no se pudo modificar.");
    }
    // mappeo
    // PersonaDTO personaDTO = mapper.map(persona, PersonaDTO.class);
}
