package com.application.movieproject.service;

import com.application.movieproject.entity.Movie;
import com.application.movieproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie with id (" + id +") not found."));
    }

    public String addMovie(Movie movie){
        Movie _movie = movieRepository.save(movie);

        return "Movie successfully added with id: (" + _movie.getId() + ")";
    }

    public String removeMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie with id (" + id +") not found."));
        movieRepository.deleteById(movie.getId());

        return "Movie successfully removed with id: (" + movie.getId() + ")";
    }

    public Movie updateMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie with id (" + id +") not found."));
        movieRepository.save(movie);
        return movie;
    }

}
