package mvc.mvc.controller.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import mvc.mvc.DTOs.SongDTO;

@Repository
public class CancionesRepository {
    
    @Autowired
    private RestTemplate rt;
    
    public ArrayList<SongDTO> getByTitle(String title) {
        String url = "http://localhost:8080/songs/get-by-name/name="+title;
        return rt.getForObject(url, ArrayList.class);
    }
}
