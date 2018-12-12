package com.ivandanylov.movieland.dao;

import com.ivandanylov.movieland.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public interface UserDao {
    User getById(int id);

    List<User> getAll();

    default User enrich(User user) {
        return getById(user.getId());
    }

    default List<User> enrich(List<User> users) {
        return users.parallelStream().map(user -> enrich(user)).collect(Collectors.toList());
    }
}
