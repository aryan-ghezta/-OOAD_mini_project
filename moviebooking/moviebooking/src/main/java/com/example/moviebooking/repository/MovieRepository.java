package com.example.moviebooking.repository;

import com.example.moviebooking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {


// Custom query: find movies by genre
List<Movie> findByGenre(String genre);

// Custom query: search by title
List<Movie> findByTitleContaining(String title);


}
