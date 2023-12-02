package com.application.movieproject.controller;

import com.application.movieproject.entity.Movie;
import com.application.movieproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
