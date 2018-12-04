package com.ivandanylov.movieland.service.api;

import com.ivandanylov.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();

    List<Movie> getRandom();
}
