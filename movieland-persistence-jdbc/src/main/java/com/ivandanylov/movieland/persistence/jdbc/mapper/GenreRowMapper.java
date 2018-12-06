package com.ivandanylov.movieland.persistence.jdbc.mapper;

import com.ivandanylov.movieland.entity.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        Genre genre = new Genre.Builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .build();

        return genre;
    }
}
