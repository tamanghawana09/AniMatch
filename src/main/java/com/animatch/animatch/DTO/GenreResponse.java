package com.animatch.animatch.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenreResponse {
    List<genreDTO> data;
}
