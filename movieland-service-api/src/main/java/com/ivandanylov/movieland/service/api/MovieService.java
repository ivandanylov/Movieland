package com.ivandanylov.movieland.service.api;

import com.ivandanylov.movieland.entity.Movie;

import java.util.List;
import java.util.Map;

public interface MovieService {
    @Deprecated ()
    List<Movie> getAll();

    List<Movie> getAll(Map<String, String> requestParameters);

    List<Movie> getRandom();

    List<Movie> getByGenreId(int genreId);
}
