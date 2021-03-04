package com.example.movie.controller;

import com.example.movie.domain.model.Movie;
import com.example.movie.domain.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> createNewMovie(@Valid @RequestBody Movie movie){
        Movie presistedMovie = movieService.createNewMovie(movie);
        return new ResponseEntity<>(presistedMovie,HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>>getMovies(){
        List<Movie>movies=movieService.getAllMovies();
        if (CollectionUtils.isEmpty(movies)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable long id){
        Movie movie = movieService.getMovie(id);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Movie>deleteMovie(@PathVariable long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie>updateMovie(@PathVariable long id,@RequestBody Movie movie){
        Movie newMovie = movieService.getMovie(id);
        newMovie.setName(movie.getName());
        newMovie.setDescription(movie.getDescription());
        movieService.updateMovie(newMovie);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

}
