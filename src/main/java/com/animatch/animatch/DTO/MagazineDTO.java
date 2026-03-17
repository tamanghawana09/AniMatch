package com.animatch.animatch.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MagazineDTO {

    @JsonProperty("mal_id")
    public int malId;
    public String name;
    public String url;
    public int count;
}
