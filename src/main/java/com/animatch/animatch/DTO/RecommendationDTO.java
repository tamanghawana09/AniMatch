package com.animatch.animatch.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class RecommendationDTO {
    // Datum fields
    @JsonProperty("mal_id")
    public String malId;
    public String content;
    public Date date;

    public String title;
    public String url;
    private List<Entry> entry;



    @Getter
    @Setter
    public static class Entry{
        @JsonProperty("mal_id")
        private Integer malId;
        private String title;
        private String url;

        private Images images;

        @Getter @Setter
        public static class Images{
            private Jpg jpg;
            private Webp webp;

            @Getter @Setter
            public static class Jpg{
                @JsonProperty("large_image_url")
                private String largeImageUrl;
                @JsonProperty("image_url")
                private String imageUrl;
            }
            @Getter @Setter
            public static class Webp{
                @JsonProperty("large_image_url")
                private String largeImageUrl;
            }
        }
    }

}
