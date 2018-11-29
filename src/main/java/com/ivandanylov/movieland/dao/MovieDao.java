package com.ivandanylov.movieland.dao;

import com.ivandanylov.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();
    List<Movie> getRandom(int count);
}
