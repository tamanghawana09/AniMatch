package com.animatch.animatch.Service;

import com.animatch.animatch.DTO.AnimeDTO;
import com.animatch.animatch.DTO.AnimeListResponse;
import com.animatch.animatch.Interface.AnimeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AnimeListServiceImpl implements AnimeListService {
    @Autowired
    private RestTemplate restTemplate;

    @Override

    public List<AnimeDTO> browse() {
        AnimeListResponse response = restTemplate.getForObject(
                "https://api.jikan.moe/v4/anime?limit=20",
                AnimeListResponse.class
        );

        if (response == null || response.getData() == null) return List.of();

        return response.getData();
    }

}
