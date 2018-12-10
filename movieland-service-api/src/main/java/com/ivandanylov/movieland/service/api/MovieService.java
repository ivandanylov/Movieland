package com.ivandanylov.movieland.service.api;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;

import java.util.List;

public interface MovieService {
    List<Movie> getAll(MovieGetAllRequestParameters requestParameters);

    List<Movie> getRandom();

    List<Movie> getByGenreId(int genreId);
}
