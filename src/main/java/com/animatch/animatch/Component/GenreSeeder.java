package com.animatch.animatch.Component;

import com.animatch.animatch.DTO.GenreResponse;
import com.animatch.animatch.Entity.Genre;
import com.animatch.animatch.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenreSeeder implements CommandLineRunner {
    @Autowired
    private GenreRepository genreRepository;

    private static final String GENRE_URL = "https://api.jikan.moe/v4/genres/anime";
    @Override
    public void run(String... args) {
        if (genreRepository.count() > 0) {
            System.out.println(">>> Genres already seeded, skipping.");
            return;
        }

        RestTemplate restTemplate = new RestTemplate();
        GenreResponse response = restTemplate.getForObject(GENRE_URL, GenreResponse.class);

        if (response == null || response.getData() == null) {
            System.out.println(">>> Failed to fetch genres from Jikan.");
            return;
        }

        List<Genre> genres = response.getData().stream()
                .map(dto -> new Genre(dto.getMalId(), dto.getName(), dto.getUrl(), dto.getCount()))
                .collect(Collectors.toList());

        genreRepository.saveAll(genres);
        System.out.println(">>> Seeded " + genres.size() + " genres.");
    }
}
