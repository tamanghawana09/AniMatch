package com.animatch.animatch.Interface;

import com.animatch.animatch.DTO.CharacterDTO;
import com.animatch.animatch.DTO.CharacterResponse;

import java.util.List;


public interface AnimeCharacterService {
    List<CharacterDTO> fetchAnimeCharacters(Long id);
}
