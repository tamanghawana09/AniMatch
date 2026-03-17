package com.animatch.animatch.Service;

import com.animatch.animatch.DTO.MagazineDTO;
import com.animatch.animatch.DTO.MagazineResponse;
import com.animatch.animatch.Interface.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MagazineServiceImpl implements MagazineService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<MagazineDTO> showMagazines(){
        MagazineResponse response = restTemplate.getForObject(
                "https://api.jikan.moe/v4/magazines",
                MagazineResponse.class
        );
        if(response == null || response.getData() == null) return List.of();

        return response.getData();
    }
}
