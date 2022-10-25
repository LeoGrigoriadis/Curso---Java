package Clase_05.actividad_1;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, Long>{

	Optional<Persona> findById(Long id);
	Collection<Persona> findAll();
	void delete(Long id);
	Persona save(Persona persona);
}
