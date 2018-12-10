package com.ivandanylov.movieland.dao.jdbc;

import com.ivandanylov.movieland.dao.MovieDao;
import com.ivandanylov.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.ivandanylov.movieland.dao.utils.SqlGenerator;
import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcMovieDao implements MovieDao {
    private JdbcTemplate jdbcTemplate;
    private MovieRowMapper movieRowMapper;
    private SqlGenerator sqlGenerator;
    private String getAllMoviesSql;
    private String getRandomMoviesSql;
    private String getMoviesByGenreIdSql;
    private int randomRowsCount;

    @Override
    public List<Movie> getAll(MovieGetAllRequestParameters requestParameters) {
        return jdbcTemplate.query(sqlGenerator.generateMovieSortSql(getAllMoviesSql, requestParameters), movieRowMapper);
    }

    @Override
    public List<Movie> getRandom() {
        return jdbcTemplate.query(getRandomMoviesSql, movieRowMapper, randomRowsCount);
    }

    @Override
    public List<Movie> getByGenreId(int genreId) {
        return jdbcTemplate.query(getMoviesByGenreIdSql, movieRowMapper, genreId);
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
    public void setSqlGenerator(SqlGenerator sqlGenerator) {
        this.sqlGenerator = sqlGenerator;
    }

    @Value("${dao.query.getAllMovies}")
    public void setGetAllMoviesSql(String getAllMoviesSql) {
        this.getAllMoviesSql = getAllMoviesSql;
    }

    @Value("${dao.query.getRandomMovies}")
    public void setGetRandomMoviesSql(String getRandomMoviesSql) {
        this.getRandomMoviesSql = getRandomMoviesSql;
    }

    @Value("${dao.config.randomMovieRowsCount:5}")
    public void setRandomRowsCount(int randomRowsCount) {
        this.randomRowsCount = randomRowsCount;
    }

    @Value("${dao.query.getMoviesByGenreId}")
    public void setGetMoviesByGenreIdSql(String getMoviesByGenreIdSql) {
        this.getMoviesByGenreIdSql = getMoviesByGenreIdSql;
    }
}
