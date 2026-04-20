package com.example.moviebooking.model;

import jakarta.persistence.*;

@Entity
public class Booking {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private Long movieId;

private String username;

// ===== GETTERS & SETTERS =====

public Long getId() {
    return id;
}

public Long getMovieId() {
    return movieId;
}

public void setMovieId(Long movieId) {
    this.movieId = movieId;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}


}
