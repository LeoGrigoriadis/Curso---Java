package clase12.clase_12.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clase12.clase_12.Models.UserType;
import clase12.clase_12.Models.User;
import clase12.clase_12.Repositories.UserTypeRepository;

@Service
public class UserTypeService {
    

    @Autowired
    UserTypeRepository userTypeRepo;
    
    public Optional<UserType> findById(Long id){
        return userTypeRepo.findById(id);
    }

    public boolean userTypeExist(User newUser){
        return userTypeRepo.findById(newUser.getUserType().getId()) != null;
    }
}
