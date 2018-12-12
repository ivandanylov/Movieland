package com.ivandanylov.movieland.dao;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;

import java.util.List;

public interface MovieDao {
    Movie getById(int movieId);

    List<Movie> getAll(MovieGetAllRequestParameters requestParameters);

    List<Movie> getRandom();

    List<Movie> getByGenreId(int genreId);
}
