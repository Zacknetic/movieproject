package com.application.movieproject.controller;

import com.application.movieproject.entity.Movie;
import com.application.movieproject.service.*;
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

    @Autowired
    private GenreService genreService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private ActorService actorService;

    @Autowired
    private MetaDataService metaDataService;

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

    @GetMapping("/edit-movie/{id}")
    public String editMovie(@PathVariable Long id, Model model) {
        Movie movie = movieService.findMovieById(id);
        model.addAttribute("genres", genreService.findAllGenres());
        model.addAttribute("publishers", publisherService.findAllPublishers());
        model.addAttribute("actors", actorService.findAllActors());
        model.addAttribute("movie", movie);
        return "edit-movie";
    }

//    @GetMapping("/save-movie/{id}")
//    public String saveMovie(@PathVariable Long id, Model model) {
//
//    }
}
