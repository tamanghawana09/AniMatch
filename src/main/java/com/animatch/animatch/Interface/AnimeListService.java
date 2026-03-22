package com.animatch.animatch.Interface;

import com.animatch.animatch.DTO.AnimeDTO;
import com.animatch.animatch.DTO.AnimeListResponse;


import java.util.List;

public interface AnimeListService {
    AnimeListResponse browse(int page);
    AnimeDTO fetchAnimeById(Long id);

}
