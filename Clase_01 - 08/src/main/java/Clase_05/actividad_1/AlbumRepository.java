package Clase_05.actividad_1;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long>{
	
	Optional<Album> findById(Long id);
	Collection<Album> findAll();
	void delete(Long id);
	Album save(Album album);
}
