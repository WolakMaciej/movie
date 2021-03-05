package com.example.movie.domain.impl;

import com.example.movie.domain.model.Movie;
import com.example.movie.domain.repository.MovieRepository;
import com.example.movie.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private Map<Long, Movie> database = new HashMap<>();

    {
        IntStream.range(0, 10)
                .forEach(i -> {
                    Movie movie = new Movie();
                    movie.setName("Name " + i);
                    movie.setDescription("Description " + i);
                    createNewMovie(movie);
                });
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Movie createNewMovie(Movie movie) {
        return movie;
    }

    @Override
    public Movie getMovieById(long id) {
        return database.get(id);
    }

    @Override
    public void deleteMovie(long id) {
        database.remove(id);

    }


    @Override
    public void updateMovie(Movie movie) {
        Movie existing = getMovieById(movie.getId());
        existing.setName(movie.getName());
        existing.setDescription(movie.getDescription());
        database.put(existing.getId(), existing);
    }


}
