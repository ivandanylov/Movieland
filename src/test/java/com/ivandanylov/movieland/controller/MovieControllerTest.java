package com.ivandanylov.movieland.controller;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.service.impl.DefaultMovieService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringJUnitWebConfig(locations = "classpath:test-servlet-context.xml")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Movie getAll servlet test")
class MovieControllerTest {
    private MockMvc mockMvc;
    private DefaultMovieService defaultMovieService;

    @BeforeAll
    public void before() {
        defaultMovieService = mock(DefaultMovieService.class);
        MovieController movieController = new MovieController();
        movieController.setMovieService(defaultMovieService);
        mockMvc = standaloneSetup(movieController).build();
    }

    @Test
    public void testGetAllMovies() throws Exception {
        List<Movie> movies = Arrays.asList(
                new Movie(1, "Name 1", "Original name 1", 1980, 123.45, 7.8, "https://link.com/image_1.jpg"),
                new Movie(2, "Name 2", "Original name 2", 1981, 67.89, 9.12, "https://link.com/image_2.jpg"));

        when(defaultMovieService.getAll()).thenReturn(movies);

        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$",  hasSize(2)))
                .andExpect(jsonPath("$[0].id", equalTo(1)))
                .andExpect(jsonPath("$[0].nameRussian", equalTo("Name 1")))
                .andExpect(jsonPath("$[0].nameNative", equalTo("Original name 1")))
                .andExpect(jsonPath("$[0].yearOfRelease", equalTo(1980)))
                .andExpect(jsonPath("$[0].price", equalTo(123.45)))
                .andExpect(jsonPath("$[0].rating", equalTo(7.8)))
                .andExpect(jsonPath("$[0].picturePath", equalTo("https://link.com/image_1.jpg")))
                .andExpect(jsonPath("$[1].id", equalTo(2)))
                .andExpect(jsonPath("$[1].nameRussian", equalTo("Name 2")))
                .andExpect(jsonPath("$[1].nameNative", equalTo("Original name 2")))
                .andExpect(jsonPath("$[1].yearOfRelease", equalTo(1981)))
                .andExpect(jsonPath("$[1].price", equalTo(67.89)))
                .andExpect(jsonPath("$[1].rating", equalTo(9.12)))
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://link.com/image_2.jpg")));

        verify(defaultMovieService, times(1)).getAll();

        verifyNoMoreInteractions(defaultMovieService);
    }
}