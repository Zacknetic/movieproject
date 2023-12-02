package com.application.movieproject.controller;

import com.application.movieproject.entity.Movie;
import com.application.movieproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public String findAllMovies(Model model) {
        List<Movie> movies = movieService.findAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/movie/{id}")
    public String findMovieById(@PathVariable Long id, Model model){
        Movie movie = movieService.findMovieById(id);
        model.addAttribute("movie", movie);
        return "list-movie";
    }

    @GetMapping("/remove-movie/{id}")
    public String deleteMovie(@PathVariable Long id, Model model) {
        movieService.removeMovieById(id);
        model.addAttribute("movies", movieService.findAllMovies());
        return "movies";
    }
}
