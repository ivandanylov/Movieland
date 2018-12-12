package com.ivandanylov.movieland.dao;

import com.ivandanylov.movieland.entity.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getByMovieId(int movieId);
}
