package com.ivandanylov.movieland.web.controller;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.service.api.MovieService;
import com.ivandanylov.movieland.web.controller.validator.ControllerParametersValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {
    private final static Logger logger = LoggerFactory.getLogger(MovieController.class);

    private MovieService movieService;
    private ControllerParametersValidator parametersValidator;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAll(
            @RequestParam Map<String, String> requestParameters) {
        logger.debug("Controller path /v1/movie with params: {}", requestParameters);

        return movieService.getAll(parametersValidator.validateMovieGetAll(requestParameters));
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

    @Autowired
    public void setParametersValidator(ControllerParametersValidator parametersValidator) {
        this.parametersValidator = parametersValidator;
    }
}
