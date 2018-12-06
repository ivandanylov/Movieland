package com.ivandanylov.movieland.persistence.api;

import com.ivandanylov.movieland.entity.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAll();
}
