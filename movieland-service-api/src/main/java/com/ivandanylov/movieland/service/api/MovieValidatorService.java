package com.ivandanylov.movieland.service.api;

import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;

public interface MovieValidatorService {
    void validateRequestParameters(MovieGetAllRequestParameters requestParameters);
}
