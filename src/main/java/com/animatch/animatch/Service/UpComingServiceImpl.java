package com.animatch.animatch.Service;

import com.animatch.animatch.DTO.UpComingDTO;
import com.animatch.animatch.DTO.UpComingResponse;
import com.animatch.animatch.Interface.UpComingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UpComingServiceImpl implements UpComingService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<UpComingDTO> showUpComingAnime(){
        UpComingResponse response = restTemplate.getForObject(
                "https://api.jikan.moe/v4/top/anime?filter=upcoming",
                UpComingResponse.class
        );
        if(response == null || response.getData() == null) return List.of();

        return response.getData();
    }
}
