package com.animatch.animatch.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AiringAnimeResponse {
    private List<AiringAnimeDTO> data;
}
