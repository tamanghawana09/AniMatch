package com.animatch.animatch.Service;

import com.animatch.animatch.DTO.RecommendationDTO;
import com.animatch.animatch.DTO.RecommendationResponse;
import com.animatch.animatch.Interface.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<RecommendationDTO> showRecommendation(){
        RecommendationResponse response = restTemplate.getForObject(
                "https://api.jikan.moe/v4/recommendations/anime",
                        RecommendationResponse.class
        );

        if(response == null || response.getData() == null) return List.of();

        return response.getData();
    }
}
