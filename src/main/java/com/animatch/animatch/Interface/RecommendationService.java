package com.animatch.animatch.Interface;

import com.animatch.animatch.DTO.RecommendationDTO;
import com.animatch.animatch.DTO.RecommendationResponse;

import java.util.List;

public interface RecommendationService {
    List<RecommendationDTO> showRecommendation();

}
