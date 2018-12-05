package com.ivandanylov.movieland.service.defaults;

import com.ivandanylov.movieland.entity.Genre;
import com.ivandanylov.movieland.persistence.api.GenreDao;
import com.ivandanylov.movieland.service.api.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("genreService")
public class DefaultGenreService implements GenreService {
    private final static Logger logger = LoggerFactory.getLogger(DefaultGenreService.class);

    GenreDao genreDao;

    @Override
    public List<Genre> getAll() {
        logger.info("[movieland] Start run getAll from genreService");

        return genreDao.getAll();
    }

    @Autowired
    public void setGenreDao(GenreDao genreDao) {
        logger.debug(String.format("[movieland] Autowired genreDao is null = %b", genreDao == null));

        this.genreDao = genreDao;

        logger.info("[movieland] setGenreDao autowired");
    }
}
