package com.example.moviebooking.controller;

import com.example.moviebooking.model.Movie;
import com.example.moviebooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {


@Autowired
private MovieService movieService;

// Show all movies
@GetMapping("/movies")
public String showMovies(Model model) {
    List<Movie> movies = movieService.getAllMovies();
    model.addAttribute("movies", movies);
    return "movies";
}

// Add movie (for testing)
@PostMapping("/add-movie")
public String addMovie(@RequestParam String title,
                       @RequestParam String genre,
                       @RequestParam String description,
                       @RequestParam int duration) {

    Movie movie = new Movie(title, genre, description, duration);
    movieService.addMovie(movie);

    return "redirect:/movies";
}


}
