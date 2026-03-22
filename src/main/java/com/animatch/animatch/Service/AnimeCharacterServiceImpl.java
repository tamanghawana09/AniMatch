package com.animatch.animatch.Service;

import com.animatch.animatch.DTO.CharacterDTO;
import com.animatch.animatch.DTO.CharacterResponse;
import com.animatch.animatch.Interface.AnimeCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AnimeCharacterServiceImpl implements AnimeCharacterService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<CharacterDTO> fetchAnimeCharacters(Long id){
        CharacterResponse response = restTemplate.getForObject(
                "https://api.jikan.moe/v4/anime/" + id + "/characters",
                CharacterResponse.class
        );

        if(response == null || response.getData() == null) return List.of();

        return response.getData().stream()
                .filter(c -> "Main".equalsIgnoreCase(c.getRole()))
                .toList();
    }

}
