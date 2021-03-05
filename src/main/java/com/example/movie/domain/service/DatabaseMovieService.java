package com.example.movie.domain.service;

import com.example.movie.domain.dao.MovieDao;
import com.example.movie.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service
public class DatabaseMovieService implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public Movie createNewMovie(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieById(long id) {
        return movieDao.findById(id).orElse(null);
    }

    @Override
    public void deleteMovie(long id) {
        movieDao.deleteById(id);

    }

    @Override
    public void updateMovie(Movie movie) {
        movieDao.save(movie);
    }
}