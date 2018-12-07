package com.ivandanylov.movieland.dao.jdbc.mapper;

import com.ivandanylov.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int rowId) throws SQLException {
        return new Movie.Builder()
                .id(resultSet.getInt("id"))
                .nameRussian(resultSet.getString("name"))
                .nameNative(resultSet.getString("original_name"))
                .yearOfRelease(resultSet.getDate("issue_date").toLocalDate().getYear())
                .price(resultSet.getDouble("price"))
                .rating(resultSet.getDouble("rating"))
                .picturePath(resultSet.getString("poster_link"))
                .build();
    }
}
