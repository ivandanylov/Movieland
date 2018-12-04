package com.ivandanylov.movieland.persistence.jdbc;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.persistence.api.MovieDao;
import com.ivandanylov.movieland.persistence.jdbc.mapper.MovieRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {
    private final static Logger logger = LoggerFactory.getLogger(JdbcMovieDao.class);

    private JdbcTemplate jdbcTemplate;
    private MovieRowMapper movieRowMapper;
    private String getAllMoviesSql;
    private String getRandomMoviesSql;
    private int randomRowsCount;

    @Override
    public List<Movie> getAll() {
        logger.info(String.format("[movieland] Get all movie sql = '%s'", getAllMoviesSql));

        return jdbcTemplate.query(getAllMoviesSql, movieRowMapper);
    }

    @Override
    public List<Movie> getRandom() {
        logger.info(String.format("[movieland] Get random movie sql = '%s' with randomRowsCount = %d",
                getRandomMoviesSql, randomRowsCount));

        return jdbcTemplate.query(getRandomMoviesSql, movieRowMapper, randomRowsCount);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setMovieRowMapper(MovieRowMapper movieRowMapper) {
        this.movieRowMapper = movieRowMapper;
    }

    @Value("${database.query.getAllMovies}")
    public void setGetAllMoviesSql(String getAllMoviesSql) {
        this.getAllMoviesSql = getAllMoviesSql;
    }

    @Value("${database.query.getRandomMovies}")
    public void setGetRandomMoviesSql(String getRandomMoviesSql) {
        this.getRandomMoviesSql = getRandomMoviesSql;
    }

    @Value("${database.config.randomRowsCount:5}")
    public void setRandomRowsCount(int randomRowsCount) {
        this.randomRowsCount = randomRowsCount;
    }
}
