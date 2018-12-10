package com.ivandanylov.movieland.service.defaults;

import com.ivandanylov.movieland.dao.MovieDao;
import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;
import com.ivandanylov.movieland.service.api.MovieService;
import com.ivandanylov.movieland.service.validator.MovieGetAllRequestParametersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMovieService implements MovieService {
    private MovieDao movieDao;
    private MovieGetAllRequestParametersValidator getAllRequestParametersValidator;

    @Override
    public List<Movie> getAll(MovieGetAllRequestParameters requestParameters) {
        if (getAllRequestParametersValidator != null) {
            getAllRequestParametersValidator.validateRequestParameters(requestParameters);
        }

        return movieDao.getAll(requestParameters);
    }

    @Override
    public List<Movie> getRandom() {
        return movieDao.getRandom();
    }

    @Override
    public List<Movie> getByGenreId(int genreId) {
        return movieDao.getByGenreId(genreId);
    }

    @Autowired
    public void setMovieDao(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Autowired
    public void setGetAllRequestParametersValidator(MovieGetAllRequestParametersValidator getAllRequestParametersValidator) {
        this.getAllRequestParametersValidator = getAllRequestParametersValidator;
    }
}
