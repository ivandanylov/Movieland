package com.ivandanylov.movieland.service.defaults;

import com.ivandanylov.movieland.entity.Genre;
import com.ivandanylov.movieland.dao.GenreDao;
import com.ivandanylov.movieland.service.api.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService {
    private GenreDao genreDao;

    @Override
    public Genre getById(int id) {
        return null;
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }

    @Autowired
    public void setGenreDao(GenreDao genreDao) {
        this.genreDao = genreDao;
    }
}
