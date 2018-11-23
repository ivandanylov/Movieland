package com.ivandanylov.movieland.dao.jdbc.mapper;

import com.ivandanylov.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("movieRowWrapper")
public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int rowId) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setNameRussian(resultSet.getString("name"));
        movie.setNameNative(resultSet.getString("original_name"));
        movie.setYearOfRelease(resultSet.getDate("issue_date").toLocalDate().getYear());
        movie.setPrice(resultSet.getDouble("price"));
        movie.setRating(resultSet.getDouble("rating"));
        movie.setPicturePath(resultSet.getString("poster_link"));

        return movie;
    }
}
