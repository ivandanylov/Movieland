package com.ivandanylov.movieland.web.controller;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;
import com.ivandanylov.movieland.service.api.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {
    private final static Logger logger = LoggerFactory.getLogger(MovieController.class);

    private MovieService movieService;

    @RequestMapping(
            value = "/{movieId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Movie getById(@PathVariable int movieId) {
        logger.debug("Controller path /v1/movie/{}", movieId);

        return movieService.getById(movieId);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAll(MovieGetAllRequestParameters requestParameters) {
        logger.debug("Controller path /v1/movie with params: {}", requestParameters);

        return movieService.getAll(requestParameters);
    }

    @RequestMapping(
            value = "/random",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getRandom() {
        logger.debug("Controller path /v1/movie/random");

        return movieService.getRandom();
    }

    @RequestMapping(
            value = "/genre/{genreId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getByGenreId(@PathVariable int genreId) {
        logger.debug("Controller path /v1/movie/genre/{}", genreId);

        return movieService.getByGenreId(genreId);
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}
