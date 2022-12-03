package clase12.clase_12.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clase12.clase_12.Models.UserType;
import clase12.clase_12.Models.User;
import clase12.clase_12.Repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepo;
    @Autowired
    UserTypeService userTypeService;

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUser(Long id) {
        //traigo el usuario para comprobar si existe.
        Optional<User> userDb = userRepo.findById(id);
        if(userDb.get() != null){
            return userDb.get();
        } else return null;
    }

    public User getUserByUsernameByPassword(String username, String password) {
        //traigo el usuario para comprobar si existe.
        Optional<User> userDb = userRepo.findUserByUsernameAndPassword(username, password);
        if(userDb.get() != null){
            return userDb.get();
        } else return null;
    }

    public boolean save(User newUser) {
        if(newUser.getId() == null || newUser.getId() == 0){
            if(userTypeService.userTypeExist(newUser)){ 
                return (userRepo.save(newUser) != null ? true : false);
             }
        }
        return false;
    }

    public boolean update(User newUser) {
        //traigo el usuario de base.
        User userDb = userRepo.findById(newUser.getId()).get();
        //compruebo que exista el usuario y su nuevo tipo de usuario.
        if( (!userTypeService.userTypeExist(newUser)) || (userDb == null) ){ 
            return false;
        }
        // me aseguro de estar seteando algo que existe.
        if(userDb.getUsername() != null || userDb.getUsername() != ""){
            userDb.setUsername(newUser.getUsername());
        }
        if(userDb.getPassword() != null || userDb.getPassword() != ""){
            userDb.setPassword(newUser.getPassword());
        }
        // guardo el nuevo tipo de usuario, antes me asegure de que exista.
        UserType tipoUs = userTypeService.findById(newUser.getUserType().getId()).get();
        userDb.setUserType(tipoUs);
        // termino el método con un save para actualizar el elemento.
        return userRepo.save(userDb) != null ;
    }

    
}
