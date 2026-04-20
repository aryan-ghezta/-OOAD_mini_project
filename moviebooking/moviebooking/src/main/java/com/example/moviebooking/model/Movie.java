package com.example.moviebooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies") // avoid SQL keyword conflicts
public class Movie {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String title;
private String genre;
private String description;
private int duration; // in minutes

// Default constructor (required by JPA)
public Movie() {}

// Parameterized constructor
public Movie(String title, String genre, String description, int duration) {
    this.title = title;
    this.genre = genre;
    this.description = description;
    this.duration = duration;
}

// Getters and Setters

public Long getId() {
    return id;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getGenre() {
    return genre;
}

public void setGenre(String genre) {
    this.genre = genre;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public int getDuration() {
    return duration;
}

public void setDuration(int duration) {
    this.duration = duration;
}


}
