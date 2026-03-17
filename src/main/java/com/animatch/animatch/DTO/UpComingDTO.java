package com.animatch.animatch.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UpComingDTO {
    @JsonProperty("mal_id")
    public int malId;
    public boolean approved;
    public String title;
    @JsonProperty("title_english")
    public String titleEnglish;
    public String type;
    public String source;
    public Integer episodes;
    public String status;
    public boolean airing;
    public String duration;
    public String rating;
    public Double score;
    public Integer scored_by;
    public Integer rank;
    public Integer popularity;
    public Integer members;
    public Integer favorites;
    public String synopsis;
    public String background;
    public String season;
    @JsonProperty("youtube_id")
    public String youtubeId;
    public String url;
    public String embed_url;
    private List<TopAnimeDTO.Genre> genres;

    // Nested Images object
    private TopAnimeDTO.Images images;

    @Getter
    @Setter
    public static class Images {
        private TopAnimeDTO.Images.Jpg jpg;
        private TopAnimeDTO.Images.Webp webp;

        @Getter
        @Setter
        public static class Jpg {
            @JsonProperty("image_url")
            private String imageUrl;
            @JsonProperty("large_image_url")
            private String largeImageUrl;
        }

        @Getter
        @Setter
        public static class Webp {
            @JsonProperty("image_url")
            private String imageUrl;
            @JsonProperty("large_image_url")
            private String largeImageUrl;
        }
    }
    public String getLargeImageUrl() {
        return images != null && images.getJpg() != null ? images.getJpg().getLargeImageUrl() : null;
    }
    @Getter @Setter
    public static class Genre{
        @JsonProperty("mal_id")
        public int malId;
        public String type;
        public String name;
        public String url;
    }
}
