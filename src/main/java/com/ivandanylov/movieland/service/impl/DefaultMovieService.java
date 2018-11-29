package com.ivandanylov.movieland.service.impl;

import com.ivandanylov.movieland.dao.MovieDao;
import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("movieService")
public class DefaultMovieService implements MovieService {
    private MovieDao movieDao;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public List<Movie> getRandom(int count) {
        return movieDao.getRandom(count);
    }

    @Autowired
    public void setJdbcMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
}
