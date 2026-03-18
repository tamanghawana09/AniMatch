package com.animatch.animatch.Controller;


import com.animatch.animatch.Entity.Anime;
import com.animatch.animatch.Service.AnimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anime")
public class AnimeController {
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService){
        this.animeService = animeService;
    }
    @GetMapping("/{id}")
    public String getAnime(@PathVariable Long id, Model model){
        Anime anime = animeService.fetchAndSaveAnime(id);
        model.addAttribute("anime",anime);
        return "anime-details";
    }

}
