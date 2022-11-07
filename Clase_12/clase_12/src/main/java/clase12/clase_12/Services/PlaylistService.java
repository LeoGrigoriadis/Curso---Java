package clase12.clase_12.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clase12.clase_12.Repositories.PlaylistRepository;

@Service
public class PlaylistService {
    
    @Autowired
    PlaylistRepository playlistRepo;
}
