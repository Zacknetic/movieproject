package com.application.movieproject.service;

import com.application.movieproject.entity.Genre;
import com.application.movieproject.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private GenreRepository genreRepository;

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public Genre findGenreByID(Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre with id (" + id + ") not found."));
    }

    public void createGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public String deleteGenreById(Long id) {
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre with id (" + id + ") not found."));
        genreRepository.delete(genre);

        return "Genre successfully removed with id: (" + genre.getId() + ")";
    }
}
