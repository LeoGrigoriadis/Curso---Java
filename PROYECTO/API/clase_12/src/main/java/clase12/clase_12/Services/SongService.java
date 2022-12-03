package clase12.clase_12.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clase12.clase_12.Models.Cancion;
import clase12.clase_12.Repositories.SongRepository;


@Service
public class SongService {
    
    @Autowired
    SongRepository cancionRepo;

    public Iterable<Cancion> getSongsByTitle(String title) {
        return cancionRepo.getSongsByTitle(title);
    }
}
