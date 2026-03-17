package com.animatch.animatch.Service;

import com.animatch.animatch.Entity.Anime;
import com.animatch.animatch.Repository.AnimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class AnimeService {

    private final WebClient webClient;

    private final AnimeRepository animeRepository;

    public AnimeService(WebClient webClient, AnimeRepository animeRepository){
        this.webClient  = webClient;
        this.animeRepository = animeRepository;
    }

    public Anime fetchAndSaveAnime(Long id){
        Map response = webClient.get()
                .uri("/anime/" + id + "/full")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        Map data = (Map) response.get("data");

        Anime anime = Anime.builder()
                .malId(Long.valueOf(data.get("mal_id").toString()))
                .title((String) data.get("title"))
                .titleEnglish((String) data.get("title_english"))
                .synopsis((String) data.get("synopsis"))
                .score(Double.valueOf(data.get("score").toString()))
                .episodes((Integer) data.get("episodes"))
                .imageUrl(((Map)((Map)data.get("images")).get("jpg")).get("large_image_url").toString())
                .season((String) data.get("season"))
                .status((String) data.get("status"))
                .build();
        return animeRepository.save(anime);
    }
}
