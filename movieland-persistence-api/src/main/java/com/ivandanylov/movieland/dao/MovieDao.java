package com.ivandanylov.movieland.dao;

import com.ivandanylov.movieland.entity.Movie;

import java.util.List;
import java.util.Map;

public interface MovieDao {
    @Deprecated
    List<Movie> getAll();

    List<Movie> getAll(Map<String, String> requestParameters);

    List<Movie> getRandom();

    List<Movie> getByGenreId(int genreId);
}
