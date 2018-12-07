package com.ivandanylov.movieland.web.controller;

import com.ivandanylov.movieland.entity.Genre;
import com.ivandanylov.movieland.service.api.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {
    private final static Logger logger = LoggerFactory.getLogger(GenreController.class);

    private GenreService genreService;

    @RequestMapping(path = "/genre", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Genre> getAll() {
        logger.debug("Controller path /v1/genre");

        return genreService.getAll();
    }

    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }
}
