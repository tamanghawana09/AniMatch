package com.animatch.animatch.Service;

import com.animatch.animatch.Entity.Genre;
import com.animatch.animatch.Interface.GenreService;
import com.animatch.animatch.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;


    @Override
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
}
