package com.ivandanylov.movieland.persistence.api;

import com.ivandanylov.movieland.entity.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();

    List<Movie> getRandom();
}
