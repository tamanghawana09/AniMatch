package com.animatch.animatch.DTO;

import com.animatch.animatch.Entity.Anime;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnimeListResponse {
    private List<AnimeDTO> data;
}
