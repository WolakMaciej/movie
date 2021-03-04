package com.example.movie.domain.service;

import com.example.movie.domain.model.Movie;

import java.util.List;

public interface MovieService  {
    List<Movie> getAllMovies();
    Movie createNewMovie(Movie movie);
    Movie getMovie(long id);
    void deleteMovie(long id);
    void updateMovie(Movie movie);

}
