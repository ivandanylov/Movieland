package com.ivandanylov.movieland.dao.jdbc.mapper;

import com.ivandanylov.movieland.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        return new User.Builder()
                .id(resultSet.getInt("id"))
                .nickname(resultSet.getString("login"))
                .build();
    }
}
