package com.ivandanylov.movieland.dao.jdbc;

import com.ivandanylov.movieland.config.yaml.YamlQuery;
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
    private YamlQuery query;
    private MovieRowMapper movieRowMapper;

    @Override
    public List<Movie> getAll() {
        return jdbcTemplate.query(query.getGetAllMovies(), movieRowMapper);
    }

    @Override
    public List<Movie> getRandom(int count) {
        return jdbcTemplate.query(query.getGetRandomMovies(), movieRowMapper, count);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setMovieRowMapper(MovieRowMapper movieRowMapper) {
        this.movieRowMapper = movieRowMapper;
    }

    @Autowired
    public void setQuery(YamlQuery query) {
        this.query = query;
    }
}
