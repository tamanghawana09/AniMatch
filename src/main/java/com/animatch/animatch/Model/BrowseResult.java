package com.animatch.animatch.Model;

import com.animatch.animatch.DTO.AnimeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BrowseResult {
    private List<AnimeDTO> animeList;
    private int currentPage;
    private int lastPage;
    private boolean hasNextPage;
    private Long selectedGenre;
    private String selectedStatus;
    private String query;
}
