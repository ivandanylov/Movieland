package com.ivandanylov.movieland.dao.jdbc;

import com.ivandanylov.movieland.dao.CountryDao;
import com.ivandanylov.movieland.dao.jdbc.mapper.CountryRowMapper;
import com.ivandanylov.movieland.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCountryDao implements CountryDao {
    private JdbcTemplate jdbcTemplate;
    private CountryRowMapper countryRowMapper;

    private String getCountryByIdSql;
    private String getAllCountriesSql;
    private String getCountriesByIdListSql;

    @Override
    public Country getById(int id) {
        return jdbcTemplate.queryForObject(getCountryByIdSql, countryRowMapper, id);
    }

    @Override
    public List<Country> getAll() {
        return jdbcTemplate.query(getAllCountriesSql, countryRowMapper);
    }

    @Override
    public List<Country> enrich(List<Country> countries) {
        return jdbcTemplate.query(getCountriesByIdListSql, countryRowMapper, countries.stream()
                .map(country -> country.getId())
                .toArray());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setCountryRowMapper(CountryRowMapper countryRowMapper) {
        this.countryRowMapper = countryRowMapper;
    }

    @Value("${dao.query.getCountryById}")
    public void setGetCountryByIdSql(String getCountryByIdSql) {
        this.getCountryByIdSql = getCountryByIdSql;
    }

    @Value("${dao.query.getAllCountries}")
    public void setGetAllCountriesSql(String getAllCountriesSql) {
        this.getAllCountriesSql = getAllCountriesSql;
    }

    @Value("${dao.query.getCountriesByIdList}")
    public void setGetCountriesByIdListSql(String getCountriesByIdListSql) {
        this.getCountriesByIdListSql = getCountriesByIdListSql;
    }
}
