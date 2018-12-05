package com.ivandanylov.movieland.service.defaults;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.persistence.api.MovieDao;
import com.ivandanylov.movieland.service.api.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("movieService")
public class DefaultMovieService implements MovieService {
    private final static Logger logger = LoggerFactory.getLogger(DefaultMovieService.class);

    private MovieDao movieDao;

    @Override
    public List<Movie> getAll() {
        logger.info("[movieland] Start run getAll from movieService");

        return movieDao.getAll();
    }

    @Override
    public List<Movie> getRandom() {
        logger.info("[movieland] Start run getRandom from movieService");

        return movieDao.getRandom();
    }

    @Autowired
    public void setMovieDao(MovieDao movieDao) {
        logger.debug(String.format("[movieland] Autowired movieDao is null = %b", movieDao == null));

        this.movieDao = movieDao;

        logger.info("[movieland] setMovieDao autowired");
    }
}
