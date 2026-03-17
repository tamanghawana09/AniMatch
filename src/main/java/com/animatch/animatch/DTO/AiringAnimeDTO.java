package com.animatch.animatch.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.annotation.JsonAppend;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
public class AiringAnimeDTO {

    public int mal_id;
    public String url;
    public Images images;
    public boolean approved;
    public String title;
    public String type;
    public String source;
    public Integer episodes;
    public String status;
    public boolean airing;
    public Aired aired;
    public String duration;
    public String rating;
    public double score;
    public Integer scored_by;
    public Integer rank;
    public Integer popularity;
    public Integer members;
    public Integer favorites;
    public String synopsis;
    public String background;
    public String season;
    public Integer year;
    public ArrayList<Genre> genres;


    public static class Aired{
        public Date from;
        @JsonProperty("to")
        public Date myto;
        public String string;
    }
    @Getter @Setter
    public static class Genre{
        @JsonProperty("mal_id")
        public int malId;
        public String type;
        public String name;
        public String url;
    }

    @Getter @Setter
    public static class Images{
        public Jpg jpg;
        public Webp webp;

        @Getter @Setter
        public static class Jpg{
            @JsonProperty("image_url")
            public String imageUrl;
            @JsonProperty("large_image_url")
            public String largeImageUrl;
        }

        @Getter @Setter
        public static class Webp{
            @JsonProperty("image_url")
            public String imageurl;
            @JsonProperty("large_Image_url")
            public String largeImageUrl;
        }
    }
}
