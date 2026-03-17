package com.animatch.animatch.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    private Long malId;

    private String name;

    private String url;

    private Integer count;
}
