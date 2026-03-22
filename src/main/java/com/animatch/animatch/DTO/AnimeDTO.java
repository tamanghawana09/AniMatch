package com.animatch.animatch.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AnimeDTO {
    @JsonProperty("mal_id")
    private Long malId;

    private String title;
    @JsonProperty("title_japanese")
    private String titleJapanese;
    private String synopsis;
    private String status;
    private Integer episodes;
    private Double score;
    private Integer rank;
    private Integer popularity;
    private Integer members;
    private Images images;
    private String season;
    private String type;
    private String duration;
    private String source;
    private String rating;
    private Aired aired;
    private List<Studios> studios;
    private List<Genres> genres;
    @JsonProperty("trailer")
    private Trailer trailer;

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
    @Getter
    @Setter
    public static class Studios{
        private String name;
    }

    @Getter
    @Setter
    public static class Genres{
        private String name;
    }
    @Getter
    @Setter
    public static class Trailer {

        @JsonProperty("youtube_id")
        private String youtubeId;

        private String url;

        @JsonProperty("embed_url")
        private String embedUrl;

        private TrailerImages images;
    }
    @Getter
    @Setter
    public static class TrailerImages {

        @JsonProperty("image_url")
        private String imageUrl;

        @JsonProperty("small_image_url")
        private String smallImageUrl;

        @JsonProperty("medium_image_url")
        private String mediumImageUrl;

        @JsonProperty("large_image_url")
        private String largeImageUrl;

        @JsonProperty("maximum_image_url")
        private String maximumImageUrl;
    }

    @Getter
    @Setter
    public static class Aired{
        public Date from;
        @JsonProperty("to")
        public Object myto;
        public Prop prop;
        public String string;

        public static class Prop{
            public From from;
            @JsonProperty("to")
            public To myto;
        }

        public static class From{
            public Integer day;
            public Integer month;
            public Integer year;
        }

        public static class To{
            public Object day;
            public Object month;
            public Object year;
        }

        public String getFormattedAired() {
            if (prop == null || prop.from == null) return "N/A";

            String fromDate = prop.from.day + "/" + prop.from.month + "/" + prop.from.year;

            if (prop.myto == null || prop.myto.day == null) {
                return fromDate + " - Present";
            }

            String toDate = prop.myto.day + "/" + prop.myto.month + "/" + prop.myto.year;

            return fromDate + " - " + toDate;
        }
    }


}
