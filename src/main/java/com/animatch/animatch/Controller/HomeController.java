package com.animatch.animatch.Controller;

import com.animatch.animatch.DTO.TopAnimeDTO;
import com.animatch.animatch.Entity.Genre;
import com.animatch.animatch.Interface.AnimeListService;
import com.animatch.animatch.Interface.GenreService;
import com.animatch.animatch.Interface.TopAnimeService;
import com.animatch.animatch.Service.AnimeService;
import com.animatch.animatch.Service.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Random;

@Controller
public class HomeController {


    @Autowired
    private AnimeListService animeListService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private TopAnimeService topAnimeService;

    @GetMapping("/")
    public String getDashboard(Model model){

        List<TopAnimeDTO> topList = topAnimeService.showTopAnime();

        TopAnimeDTO heroAnime = topList.get(new Random().nextInt(Math.min(20, topList.size())));


        model.addAttribute("heroAnime", heroAnime);
        model.addAttribute("genres",genreService.getAllGenres());
        return "dashboard";
    }
    @GetMapping("/browse")
    public String browse(Model model) {
        model.addAttribute("animeList", animeListService.browse());
        return "browse";
    }

}
