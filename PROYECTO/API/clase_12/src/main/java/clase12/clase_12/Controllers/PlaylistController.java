package clase12.clase_12.Controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import clase12.clase_12.Configuration.JwtTokenUtils;
import clase12.clase_12.Models.Cancion;
import clase12.clase_12.Services.PlaylistService;

@RestController
@RequestMapping("/playlists/")
public class PlaylistController {
    
    @Autowired
    PlaylistService playlistService;
    @Autowired
    private JwtTokenUtils tokenUtils;

    @GetMapping("/get-by-name/name={title}")
    public ResponseEntity<?> getUsers(@RequestHeader("token") String token, @PathVariable("title") String title){
        HashMap<String, Object> responseMap = new HashMap<>();
        try{
            if(!tokenUtils.validateToken(token)){
                responseMap.put("error", true);
                responseMap.put("message", "ERROR: No estás autorizado para acceder a este recurso");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMap);
            } 
            Iterable<Cancion> playlists = playlistService.getPlaylistsByTitle(title);
            responseMap.put("error", false);
            responseMap.put("users", playlists);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseMap);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR: Not Found Exception.");
        }
    }
}
