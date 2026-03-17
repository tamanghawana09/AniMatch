package com.animatch.animatch.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="anime")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Anime {
    @Id
    private Long malId;

    private String title;
    private String titleEnglish;

    @Column(length=2000)
    private String synopsis;

    private Double score;

    private Integer episodes;
    private String status;
    private String imageUrl;
    private String season;
    private Integer year;

    @ManyToMany
    @JoinTable(
            name="anime_genres",
            joinColumns = @JoinColumn(name="anime_id"),
            inverseJoinColumns = @JoinColumn(name="genre_id")
    )
    private List<Genre> genres;
}
