package com.animatch.animatch.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {

    public Character character;
    @JsonProperty("mal_id")
    public Long malId;
    public String role;

    @Getter
    @Setter
    public static class Character{
        @JsonProperty("mal_id")
        public int malId;
        public String url;
        public Images images;
        public String name;

        @Getter
        @Setter
        public static class Images{
            public Jpg jpg;
            public Webp webp;

            @Getter
            @Setter
            public static class Jpg{
                @JsonProperty("image_url")
                public String imageUrl;
            }
            @Getter
            @Setter
            public static class Webp{
                @JsonProperty("image_url")
                public String imageUrl;
                @JsonProperty("small_image_url")
                public String smallImageUrl;
            }

        }


    }

}
