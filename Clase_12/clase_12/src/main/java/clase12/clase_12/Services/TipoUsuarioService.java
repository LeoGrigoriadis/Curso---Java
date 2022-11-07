package clase12.clase_12.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clase12.clase_12.Models.TipoUsuario;
import clase12.clase_12.Models.Usuario;
import clase12.clase_12.Repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {
    

    @Autowired
    TipoUsuarioRepository tipoUsuarioRepo;
    
    public Optional<TipoUsuario> findById(Long id){
        return tipoUsuarioRepo.findById(id);
    }

    public boolean tipoUsuarioExist(Usuario nuevoUsuario){
        return tipoUsuarioRepo.findById(nuevoUsuario.getTipoUsuario().getId()) != null;
    }
}
