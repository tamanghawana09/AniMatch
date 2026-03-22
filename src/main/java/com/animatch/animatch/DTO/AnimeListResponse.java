package com.animatch.animatch.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnimeListResponse {
    private List<AnimeDTO> data;

    private Pagination pagination;

    @Getter
    @Setter
    public static class Pagination {
        @JsonProperty("last_visible_page")
        private Integer lastVisiblePage;

        @JsonProperty("has_next_page")
        private Boolean hasNextPage;

        @JsonProperty("current_page")
        private Integer currentPage;

        private Items items;

        @Getter
        @Setter
        public static class Items {
            private Integer count;
            private Integer total;

            @JsonProperty("per_page")
            private Integer perPage;
        }
    }
}