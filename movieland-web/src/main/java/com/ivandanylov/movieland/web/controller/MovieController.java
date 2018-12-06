package com.ivandanylov.movieland.web.controller;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.service.api.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private final static Logger logger = LoggerFactory.getLogger(MovieController.class);

    private MovieService movieService;

    @RequestMapping(path = "/test", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getRoot() {
        logger.debug("[movieland] Controller path /v1/test");

        return "Controller alive";
    }

    @RequestMapping(path = "/movie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAll() {
        logger.debug("[movieland] Controller path /v1/movie");

        return movieService.getAll();
    }

    @RequestMapping(path = "/movie/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getRandom() {
        logger.debug("[movieland] Controller path /v1/movie/random");

        return movieService.getRandom();
    }

    @RequestMapping(path = "/movie/genre/{genreId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getByGenreId(@PathVariable int genreId) {
        logger.debug(String.format("[movieland] Controller path /v1/movie/genre/%d", genreId));

        return movieService.getByGenreId(genreId);
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        logger.debug(String.format("[movieland] Movie service is null = %b", movieService == null));

        this.movieService = movieService;

        logger.debug("[movieland] setMovieService autowired");
    }
}
