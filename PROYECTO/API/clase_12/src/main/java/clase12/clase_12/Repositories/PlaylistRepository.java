package clase12.clase_12.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import clase12.clase_12.Models.Cancion;
import clase12.clase_12.Models.Playlist;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long>{

    Iterable<Cancion> getPlaylistsByTitle(String title);
}
