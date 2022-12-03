package mvc.mvc.controller.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.mvc.DTOs.SongDTO;
import mvc.mvc.controller.repository.CancionesRepository;

@Service
public class CancionesService {
    
    @Autowired
    private CancionesRepository cancionesRepo;

    public ArrayList<SongDTO> getByTitle(String title) {
        
        return cancionesRepo.getByTitle(title);
    }
}
