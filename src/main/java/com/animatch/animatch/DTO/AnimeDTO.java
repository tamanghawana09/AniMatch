package com.animatch.animatch.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimeDTO {
    @JsonProperty("mal_id")
    private Long malId;

    private String title;
    private String synopsis;
    private String status;
    private Integer episodes;
    private Double score;
    private Integer rank;
    private Integer popularity;
    private Images images;

    @Getter
    @Setter
    public static class Images{
        private ImageUrl jpg;

        @Getter @Setter
        public static class ImageUrl{
            @JsonProperty("image_url")
            private String imageUrl;

            @JsonProperty("large_image_url")
            private String largeImageUrl;
        }
    }
}
