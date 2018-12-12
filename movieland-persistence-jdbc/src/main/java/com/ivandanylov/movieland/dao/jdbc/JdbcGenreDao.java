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
    private GenreRowMapper genreRowMapper;

    private String getAllGenresSql;
    private String getGenreByIdSql;
    private String getGenresByIdListSql;

    @Override
    public Genre getById(int id) {
        return jdbcTemplate.queryForObject(getGenreByIdSql, genreRowMapper, id);
    }

    @Override
    public List<Genre> getAll() {
        return jdbcTemplate.query(getAllGenresSql, genreRowMapper);
    }

    @Override
    public List<Genre> enrich(List<Genre> genres) {
        return jdbcTemplate.query(getGenresByIdListSql, genreRowMapper, genres.stream()
                .map(genre -> genre.getId())
                .toArray());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGenreRowMapper(GenreRowMapper genreRowMapper) {
        this.genreRowMapper = genreRowMapper;
    }

    @Value("${dao.query.getAllGenres}")
    public void setGetAllGenresSql(String getAllGenresSql) {
        this.getAllGenresSql = getAllGenresSql;
    }

    @Value("${dao.query.getGenreById}")
    public void setGetGenreByIdSql(String getGenreByIdSql) {
        this.getGenreByIdSql = getGenreByIdSql;
    }

    @Value("${dao.query.getGenresByIdList}")
    public void setGetGenresByIdListSql(String getGenresByIdListSql) {
        this.getGenresByIdListSql = getGenresByIdListSql;
    }
}
