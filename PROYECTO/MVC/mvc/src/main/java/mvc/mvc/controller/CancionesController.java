package mvc.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import mvc.mvc.controller.service.CancionesService;

@Controller
public class CancionesController {
    
    @Autowired
    private CancionesService cancionesService;
    
    @GetMapping("/songs")
    public String viewSongs() {
        return "Songs";
    }

    @GetMapping("/search-songs")
    public  String searchSongs(@ModelAttribute("title") String title, Model model){
        
        model.addAttribute("songs", cancionesService.getByTitle(title));
        return "Search-songs";
    }
}
