package com.ivandanylov.movieland.dao.cache;

import com.ivandanylov.movieland.dao.UserDao;
import com.ivandanylov.movieland.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class CachedUserDao implements UserDao {
    private UserDao userDao;
    private volatile Map<Integer, User> users = new HashMap<>();

    @PostConstruct
    public void refresh() {
        HashMap<Integer, User> countries = new HashMap<>();

        for (User user : userDao.getAll()) {
            countries.put(user.getId(), user);
        }

        this.users = countries;
    }

    @Override
    public User getById(int id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
