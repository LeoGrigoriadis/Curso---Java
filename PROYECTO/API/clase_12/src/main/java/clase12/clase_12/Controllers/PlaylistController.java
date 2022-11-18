package clase12.clase_12.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import clase12.clase_12.Services.PlaylistService;

@RestController
public class PlaylistController {
    
    @Autowired
    PlaylistService playlistService;
}
