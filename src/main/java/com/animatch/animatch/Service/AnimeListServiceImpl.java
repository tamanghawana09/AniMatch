package com.animatch.animatch.Service;

import com.animatch.animatch.DTO.AnimeDTO;
import com.animatch.animatch.DTO.AnimeListResponse;
import com.animatch.animatch.DTO.AnimeResponse;
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
    public AnimeListResponse browse(int page) {
        String url = "https://api.jikan.moe/v4/anime?limit=20&page=" + page;

        AnimeListResponse response = restTemplate.getForObject(url, AnimeListResponse.class);

        if (response == null) {
            response = new AnimeListResponse();
            response.setData(List.of());
            response.setPagination(new AnimeListResponse.Pagination());
        }

        return response;
    }

    @Override
    public AnimeDTO  fetchAnimeById(Long id){
        AnimeResponse response1 = restTemplate.getForObject (
                "https://api.jikan.moe/v4/anime/" + id,
                AnimeResponse.class
        );
        return response1 != null ? response1.getData() : null;
    }


}
