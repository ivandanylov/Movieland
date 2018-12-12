package com.ivandanylov.movieland.dao.jdbc;

import com.ivandanylov.movieland.dao.UserDao;
import com.ivandanylov.movieland.dao.jdbc.mapper.UserRowMapper;
import com.ivandanylov.movieland.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserDao implements UserDao {
    private JdbcTemplate jdbcTemplate;
    private UserRowMapper userRowMapper;

    private String getUserByIdSql;
    private String getAllUsersSql;
    private String getUsersByIdListSql;

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject(getUserByIdSql, userRowMapper, id);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query(getAllUsersSql, userRowMapper);
    }

    @Override
    public List<User> enrich(List<User> users) {
        return jdbcTemplate.query(getUsersByIdListSql, userRowMapper, users.stream()
                .map(user -> user.getId())
                .toArray());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setUserRowMapper(UserRowMapper userRowMapper) {
        this.userRowMapper = userRowMapper;
    }

    @Value("${dao.query.getUserById}")
    public void setGetUserByIdSql(String getUserByIdSql) {
        this.getUserByIdSql = getUserByIdSql;
    }

    @Value("${dao.query.getAllUsers}")
    public void setGetAllUsersSql(String getAllUsersSql) {
        this.getAllUsersSql = getAllUsersSql;
    }

    @Value("${dao.query.getUsersByIdList}")
    public void setGetUsersByIdListSql(String getUsersByIdListSql) {
        this.getUsersByIdListSql = getUsersByIdListSql;
    }
}
