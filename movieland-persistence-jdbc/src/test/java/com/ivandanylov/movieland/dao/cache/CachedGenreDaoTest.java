package com.ivandanylov.movieland.dao.cache;

import com.ivandanylov.movieland.dao.GenreDao;
import com.ivandanylov.movieland.entity.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CachedGenreDaoTest {
    @Test
    void testGetAll() {
        GenreDao mockGenreDao = mock(GenreDao.class);
        when(mockGenreDao.getAll()).thenReturn(Arrays.asList(
                new Genre.Builder()
                        .id(1)
                        .name("Genre name 1")
                        .build(),
                new Genre.Builder()
                        .id(2)
                        .name("Genre name 2")
                        .build(),
                new Genre.Builder()
                        .id(3)
                        .name("Genre name 3")
                        .build()
        ));

        CachedGenreDao cachedGenreDao = new CachedGenreDao();
        cachedGenreDao.setGenreDao(mockGenreDao);
        cachedGenreDao.refresh();

        List<Genre> expectedGenres = Arrays.asList(
                new Genre.Builder()
                        .id(1)
                        .name("Genre name 1")
                        .build(),
                new Genre.Builder()
                        .id(2)
                        .name("Genre name 2")
                        .build(),
                new Genre.Builder()
                        .id(3)
                        .name("Genre name 3")
                        .build()
        );
        List<Genre> actualGenres = cachedGenreDao.getAll();

        for (int i = 0; i <3; i++) {
            Assertions.assertEquals(expectedGenres.get(i), actualGenres.get(i));
        }

    }
}
