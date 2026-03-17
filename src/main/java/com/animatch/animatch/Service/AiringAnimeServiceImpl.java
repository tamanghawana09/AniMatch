package com.animatch.animatch.Service;

import com.animatch.animatch.DTO.AiringAnimeDTO;
import com.animatch.animatch.DTO.AiringAnimeResponse;
import com.animatch.animatch.Interface.AiringAnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AiringAnimeServiceImpl implements AiringAnimeService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<AiringAnimeDTO> showAiringAnime(){
        AiringAnimeResponse response = restTemplate.getForObject(
          "https://api.jikan.moe/v4/top/anime?filter=airing",
                AiringAnimeResponse.class
        );
        if(response == null || response.getData() == null) return List.of();

        return response.getData();
    }
}
