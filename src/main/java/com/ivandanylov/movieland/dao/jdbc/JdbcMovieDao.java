package com.ivandanylov.movieland.dao.jdbc;

import com.ivandanylov.movieland.dao.MovieDao;
import com.ivandanylov.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.ivandanylov.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jdbcMovieDao")
public class JdbcMovieDao implements MovieDao {
    private JdbcTemplate jdbcTemplate;
    private String getAllSql;
    private MovieRowMapper movieRowMapper;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGetAllSql(String getAllSql) {
        this.getAllSql = getAllSql;
    }

    @Autowired
    public void setMovieRowMapper(MovieRowMapper movieRowMapper) {
        this.movieRowMapper = movieRowMapper;
    }

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(getAllSql, movieRowMapper);
    }
}
