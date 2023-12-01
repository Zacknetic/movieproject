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

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie with id (" + id +") not found."));
    }

    public String addMovie(Movie movie){
        Movie _movie = movieRepository.save(movie);

        return "Movie successfully added with id: (" + _movie.getId() + ")";
    }

    public String removeMovieById(long id) {
        if(!movieRepository.existsById(id)) return "${id} not found";
        movieRepository.deleteById(id);

        return "Movie successfully removed with id: (" + id + ")";
    }

    public Movie updateMovieById(long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie with id (" + id +") not found."));
        movieRepository.save(movie);
        return movie;
    }

}
