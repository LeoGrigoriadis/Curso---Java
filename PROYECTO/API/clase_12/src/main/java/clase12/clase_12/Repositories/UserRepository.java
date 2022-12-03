package clase12.clase_12.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import clase12.clase_12.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User getByUsername(String username);
    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
