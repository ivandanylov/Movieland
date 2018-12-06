package com.ivandanylov.movieland.web.controller;

import com.ivandanylov.movieland.entity.Genre;
import com.ivandanylov.movieland.service.defaults.DefaultGenreService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Genre servlet test")
class GenreControllerTest {
    private MockMvc mockMvc;

    @Mock
    private DefaultGenreService genreServiceMock;

    @InjectMocks
    private GenreController genreController = new GenreController();

    @BeforeAll
    void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(genreController).build();
    }

    @Test
    void testGetAllGenres() throws Exception {
        List<Genre> genres = Arrays.asList(
                new Genre.Builder()
                        .id(1)
                        .name("Genre 1")
                        .build(),
                new Genre.Builder()
                        .id(2)
                        .name("Genre 2")
                        .build());

        when(genreServiceMock.getAll()).thenReturn(genres);

        mockMvc.perform(get("/genre"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("Genre 1")))
                .andExpect(jsonPath("$[1].id", equalTo(2)))
                .andExpect(jsonPath("$[1].name", equalTo("Genre 2")));

        verify(genreServiceMock, times(1)).getAll();

        verifyNoMoreInteractions(genreServiceMock);
    }
}
