package com.example.movie.domain.impl;

import com.example.movie.domain.model.Movie;
import com.example.movie.domain.repository.MovieRepository;
import com.example.movie.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie createNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovie(long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMovie(long id) {
        movieRepository.deleteById(id);

    }

    @Override
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }


}
