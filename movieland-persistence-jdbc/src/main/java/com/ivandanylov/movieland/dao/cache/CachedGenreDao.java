package com.ivandanylov.movieland.dao.cache;

import com.ivandanylov.movieland.dao.GenreDao;
import com.ivandanylov.movieland.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class CachedGenreDao implements GenreDao {
    private GenreDao genreDao;
    private volatile Map<Integer, Genre> genres;

    @PostConstruct
    @Scheduled(fixedDelayString = "${scheduler.genreFixedDelayInMilliseconds:14400000}",
            initialDelayString = "${scheduler.genreInitialDelayInMilliseconds:1000}")
    public void refresh() {
        HashMap<Integer, Genre> genres = new HashMap<>();

        for (Genre genre : genreDao.getAll()) {
            genres.put(genre.getId(), genre);
        }

        this.genres = genres;
    }

    @Override
    public Genre getById(int id) {
        return genres.get(id);
    }

    @Override
    public List<Genre> getAll() {
        return new ArrayList<>(genres.values());
    }

    @Autowired
    public void setGenreDao(GenreDao genreDao) {
        this.genreDao = genreDao;
    }
}
