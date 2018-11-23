package com.ivandanylov.movieland.dao.jdbc.mapper;

import com.ivandanylov.movieland.entity.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("Movie row mapper test")
public class MovieRowMapperTest {
    @Test
    public void testMapRow() throws Exception {
        MovieRowMapper movieRowMapper = new MovieRowMapper();
        LocalDate localDate = LocalDate.of(1980, 4, 9);

        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("name")).thenReturn("Movie name");
        when(resultSet.getString("original_name")).thenReturn("Original movie name");
        when(resultSet.getDate("issue_date")).thenReturn(Date.valueOf(localDate));
        when(resultSet.getDouble("price")).thenReturn(123.45);
        when(resultSet.getDouble("rating")).thenReturn(9.8);
        when(resultSet.getString("poster_link")).thenReturn("https://link.com/image.jpg");

        Movie actualMovie = movieRowMapper.mapRow(resultSet, 1);

        Assertions.assertEquals(1, actualMovie.getId());
        Assertions.assertEquals("Movie name", actualMovie.getNameRussian());
        Assertions.assertEquals("Original movie name", actualMovie.getNameNative());
        Assertions.assertEquals(localDate.getYear(), actualMovie.getYearOfRelease());
        Assertions.assertEquals(123.45, actualMovie.getPrice());
        Assertions.assertEquals(9.8, actualMovie.getRating());
        Assertions.assertEquals("https://link.com/image.jpg", actualMovie.getPicturePath());
    }
}
