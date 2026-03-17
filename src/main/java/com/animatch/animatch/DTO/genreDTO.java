package com.animatch.animatch.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class genreDTO {
    @JsonProperty("mal_id")
    private Long malId;

    private String name;
    private String url;
    private Integer count;
}
