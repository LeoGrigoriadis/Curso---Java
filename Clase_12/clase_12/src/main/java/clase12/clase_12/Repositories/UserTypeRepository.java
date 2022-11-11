package clase12.clase_12.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import clase12.clase_12.Models.UserType;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Long>{
    
}
