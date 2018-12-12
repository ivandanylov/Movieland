package com.ivandanylov.movieland.service.api;

import com.ivandanylov.movieland.entity.Genre;

import java.util.List;
import java.util.stream.Collectors;

public interface GenreService {
    Genre getById(int id);

    List<Genre> getAll();

    default Genre enrich(Genre genre) {
        return getById(genre.getId());
    }

    default List<Genre> enrich(List<Genre> genres) {
        return genres.parallelStream().map(genre -> enrich(genre)).collect(Collectors.toList());
    }
}
