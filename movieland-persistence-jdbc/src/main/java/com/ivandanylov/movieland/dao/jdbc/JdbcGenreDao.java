package com.ivandanylov.movieland.dao.jdbc;

import com.ivandanylov.movieland.entity.Genre;
import com.ivandanylov.movieland.dao.GenreDao;
import com.ivandanylov.movieland.dao.jdbc.mapper.GenreRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private JdbcTemplate jdbcTemplate;
    private GenreRowMapper movieRowMapper;
    private String getAllGenresSql;

    @Override
    public List<Genre> getAll() {
        return jdbcTemplate.query(getAllGenresSql, movieRowMapper);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setMovieRowMapper(GenreRowMapper movieRowMapper) {
        this.movieRowMapper = movieRowMapper;
    }

    @Value("${dao.query.getAllGenres}")
    public void setGetAllGenresSql(String getAllGenresSql) {
        this.getAllGenresSql = getAllGenresSql;
    }
}
