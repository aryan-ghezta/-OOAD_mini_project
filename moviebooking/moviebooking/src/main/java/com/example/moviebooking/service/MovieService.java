package com.example.moviebooking.service;

import com.example.moviebooking.model.Movie;
import com.example.moviebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


@Autowired
private MovieRepository movieRepository;

// Get all movies
public List<Movie> getAllMovies() {
    return movieRepository.findAll();
}

// Add a new movie
public Movie addMovie(Movie movie) {
    return movieRepository.save(movie);
}

// Search movies by title
public List<Movie> searchByTitle(String title) {
    return movieRepository.findByTitleContaining(title);
}

// Get movies by genre
public List<Movie> getByGenre(String genre) {
    return movieRepository.findByGenre(genre);
}


}
