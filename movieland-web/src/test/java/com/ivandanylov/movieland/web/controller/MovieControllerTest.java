package com.ivandanylov.movieland.web.controller;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.service.defaults.DefaultMovieService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Movie servlet test")
class MovieControllerTest {
    private MockMvc mockMvc;

    @Mock
    private DefaultMovieService movieServiceMock;

    @InjectMocks
    private MovieController movieController = new MovieController();

    @BeforeAll
    void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(movieController).build();
    }

    @Test
    void testGetAllMovies() throws Exception {
        List<Movie> movies = Arrays.asList(
                new Movie.Builder()
                        .id(1)
                        .nameRussian("Name 1")
                        .nameNative("Original name 1")
                        .yearOfRelease(1980)
                        .price(123.45)
                        .rating(7.8)
                        .picturePath("https://link.com/image_1.jpg")
                        .build(),
                new Movie.Builder()
                        .id(2)
                        .nameRussian("Name 2")
                        .nameNative("Original name 2")
                        .yearOfRelease(1981)
                        .price(67.89)
                        .rating(9.12)
                        .picturePath("https://link.com/image_2.jpg")
                        .build());

        when(movieServiceMock.getAll()).thenReturn(movies);

        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
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

        verify(movieServiceMock, times(1)).getAll();

        verifyNoMoreInteractions(movieServiceMock);
    }

    @Test
    void testGetRandomMovies() throws Exception {
        List<Movie> movies = Arrays.asList(
                new Movie.Builder()
                        .id(1)
                        .nameRussian("Name 1")
                        .nameNative("Original name 1")
                        .yearOfRelease(1980)
                        .price(123.45)
                        .rating(7.8)
                        .picturePath("https://link.com/image_1.jpg")
                        .build(),
                new Movie.Builder()
                        .id(2)
                        .nameRussian("Name 2")
                        .nameNative("Original name 2")
                        .yearOfRelease(1981)
                        .price(67.89)
                        .rating(9.12)
                        .picturePath("https://link.com/image_2.jpg")
                        .build(),
                new Movie.Builder()
                        .id(3)
                        .nameRussian("Name 3")
                        .nameNative("Original name 3")
                        .yearOfRelease(1982)
                        .price(67.90)
                        .rating(9.13)
                        .picturePath("https://link.com/image_3.jpg")
                        .build());

        when(movieServiceMock.getRandom()).thenReturn(movies);

        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(3)))
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
                .andExpect(jsonPath("$[1].picturePath", equalTo("https://link.com/image_2.jpg")))
                .andExpect(jsonPath("$[2].id", equalTo(3)))
                .andExpect(jsonPath("$[2].nameRussian", equalTo("Name 3")))
                .andExpect(jsonPath("$[2].nameNative", equalTo("Original name 3")))
                .andExpect(jsonPath("$[2].yearOfRelease", equalTo(1982)))
                .andExpect(jsonPath("$[2].price", equalTo(67.90)))
                .andExpect(jsonPath("$[2].rating", equalTo(9.13)))
                .andExpect(jsonPath("$[2].picturePath", equalTo("https://link.com/image_3.jpg")));


        verify(movieServiceMock, times(1)).getRandom();

        verifyNoMoreInteractions(movieServiceMock);
    }
}