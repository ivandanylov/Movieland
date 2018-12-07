package com.ivandanylov.movieland.dao.jdbc.mapper;

import com.ivandanylov.movieland.entity.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Genre row mapper test")
class GenreRowMapperTest {
    @Test
    void testMapRow() throws SQLException {
        GenreRowMapper genreRowMapper = new GenreRowMapper();

        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("Genre name");

        Genre actualGenre = genreRowMapper.mapRow(resultSet, 1);

        Assertions.assertNotNull(actualGenre);
        Assertions.assertEquals(1, actualGenre.getId());
        Assertions.assertEquals("Genre name", actualGenre.getName());
    }
}
