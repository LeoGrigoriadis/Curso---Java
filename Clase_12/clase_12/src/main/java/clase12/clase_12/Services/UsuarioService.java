package clase12.clase_12.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clase12.clase_12.Models.TipoUsuario;
import clase12.clase_12.Models.Usuario;
import clase12.clase_12.Repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepo;
    @Autowired
    TipoUsuarioService tipoUsService;

    public Iterable<Usuario> getUsers() {
        return usuarioRepo.findAll();
    }

    public Usuario getUser(Long id) {
        //traigo el usuario para comprobar si existe.
        Optional<Usuario> userDb = usuarioRepo.findById(id);
        if(userDb.get() != null){
            return userDb.get();
        } else return null;
    }

    public boolean save(Usuario nuevoUsuario) {
        if(nuevoUsuario.getId() == null || nuevoUsuario.getId() == 0){
            if(tipoUsService.tipoUsuarioExist(nuevoUsuario)){ 
                return (usuarioRepo.save(nuevoUsuario) != null ? true : false);
             }
        }
        return false;
    }

    public boolean update(Usuario nuevoUsuario) {
        //traigo el usuario de base.
        Usuario usuarioDb = usuarioRepo.findById(nuevoUsuario.getId()).get();
        //compruebo que exista el usuario y su nuevo tipo de usuario.
        if( (!tipoUsService.tipoUsuarioExist(nuevoUsuario)) || (usuarioDb == null) ){ 
            return false;
        }
        // me aseguro de estar seteando algo que existe.
        if(usuarioDb.getUsuario() != null || usuarioDb.getUsuario() != ""){
            usuarioDb.setUsuario(nuevoUsuario.getUsuario());
        }
        if(usuarioDb.getContrasena() != null || usuarioDb.getContrasena() != ""){
            usuarioDb.setContrasena(nuevoUsuario.getContrasena());
        }
        // guardo el nuevo tipo de usuario, antes me asegure de que exista.
        TipoUsuario tipoUs = tipoUsService.findById(nuevoUsuario.getTipoUsuario().getId()).get();
        usuarioDb.setTipoUsuario(tipoUs);
        // termino el método con un save para actualizar el elemento.
        return usuarioRepo.save(usuarioDb) != null ;
    }

    
}
