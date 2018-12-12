package com.ivandanylov.movieland.dao.jdbc;

import com.ivandanylov.movieland.dao.ReviewDao;
import com.ivandanylov.movieland.dao.jdbc.mapper.ReviewRowMapper;
import com.ivandanylov.movieland.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcReviewDao implements ReviewDao {
    private JdbcTemplate jdbcTemplate;
    private ReviewRowMapper reviewRowMapper;

    private String getReviewsByMovieIdSql;

    @Override
    public List<Review> getByMovieId(int movieId) {
        return jdbcTemplate.query(getReviewsByMovieIdSql, reviewRowMapper, movieId);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setReviewRowMapper(ReviewRowMapper reviewRowMapper) {
        this.reviewRowMapper = reviewRowMapper;
    }

    @Value("${dao.query.getReviewsByMovieId}")
    public void setGetReviewsByMovieIdSql(String getReviewsByMovieIdSql) {
        this.getReviewsByMovieIdSql = getReviewsByMovieIdSql;
    }
}
