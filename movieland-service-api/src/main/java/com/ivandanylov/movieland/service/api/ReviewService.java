package com.ivandanylov.movieland.service.api;

import com.ivandanylov.movieland.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getByMovieId(int movieId);
}
