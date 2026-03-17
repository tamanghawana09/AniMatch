package com.animatch.animatch.Service;

import com.animatch.animatch.DTO.TopAnimeDTO;
import com.animatch.animatch.DTO.TopAnimeResponse;
import com.animatch.animatch.Interface.TopAnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TopAnimeServiceImpl implements TopAnimeService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<TopAnimeDTO> showTopAnime(){
        TopAnimeResponse response = restTemplate.getForObject(
                "https://api.jikan.moe/v4/top/anime",
                TopAnimeResponse.class);
        if(response == null || response.getData() == null) return List.of();

        return response.getData();
    }


}
