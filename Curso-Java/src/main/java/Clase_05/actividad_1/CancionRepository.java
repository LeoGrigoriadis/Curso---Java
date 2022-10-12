package Clase_05.actividad_1;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CancionRepository extends CrudRepository<Cancion, Long>{
	
	Optional<Cancion> findById(Long id);
	Collection<Cancion> findAll();
	void delete(Long id);
	Cancion save(Cancion cancion);
}
