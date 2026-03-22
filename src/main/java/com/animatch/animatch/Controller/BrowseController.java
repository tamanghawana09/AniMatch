package com.animatch.animatch.Controller;

import com.animatch.animatch.DTO.AnimeDTO;
import com.animatch.animatch.DTO.AnimeListResponse;
import com.animatch.animatch.DTO.CharacterDTO;
import com.animatch.animatch.DTO.RecommendationDTO;
import com.animatch.animatch.Interface.AnimeListService;
import com.animatch.animatch.Interface.RecommendationService;
import com.animatch.animatch.Service.AnimeCharacterServiceImpl;
import com.animatch.animatch.Service.AnimeListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/anime")
public class BrowseController {
    @Autowired
    private AnimeListServiceImpl animeListServiceImpl;

    @Autowired
    private AnimeCharacterServiceImpl animeCharacterServiceImpl;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private AnimeListService animeListService;

    @GetMapping("/{id}")
    public String getAnimeDetails(@PathVariable Long id, Model model){
        AnimeDTO detailAnime = animeListServiceImpl.fetchAnimeById(id);
        if (detailAnime == null) {
            return "error";
        }

        List<CharacterDTO> animeCharacter = animeCharacterServiceImpl.fetchAnimeCharacters(id);
        if(animeCharacter == null){
            return "error";
        }

        model.addAttribute("recommend", recommendationService.showRecommendation());
        List<RecommendationDTO> allAnime= recommendationService.showRecommendation();
        Collections.shuffle(allAnime);
        List<RecommendationDTO> random4 = allAnime.stream().limit(4).toList();
        model.addAttribute("animeList",random4);
        model.addAttribute("character", animeCharacter);
        model.addAttribute("anime",detailAnime);
        return "anime-details";
    }


}
