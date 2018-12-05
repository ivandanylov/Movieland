package com.ivandanylov.movieland.persistence.jdbc;

import com.ivandanylov.movieland.entity.Genre;
import com.ivandanylov.movieland.persistence.api.GenreDao;
import com.ivandanylov.movieland.persistence.jdbc.mapper.GenreRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcGenreDao implements GenreDao {
    private final static Logger logger = LoggerFactory.getLogger(JdbcGenreDao.class);

    private JdbcTemplate jdbcTemplate;
    private GenreRowMapper movieRowMapper;
    private String getAllGenresSql;

    @Override
    public List<Genre> getAll() {
        logger.debug(String.format("[movieland] Get all genres sql = '%s'", getAllGenresSql));

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

    @Value("${database.query.getAllGenres}")
    public void setGetAllGenresSql(String getAllGenresSql) {
        this.getAllGenresSql = getAllGenresSql;
    }
}
