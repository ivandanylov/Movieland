package com.ivandanylov.movieland.web.controller.request.parameters.argumentresolver;

import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

public class MovieGetAllRequestParametersArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(MovieGetAllRequestParameters.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory
    ) {
        MovieGetAllRequestParameters.Builder movieRequestParameters = new MovieGetAllRequestParameters.Builder();

        for (Map.Entry<String, String[]> requestParameter : nativeWebRequest.getParameterMap().entrySet()) {
            if (requestParameter.getKey().equals("rating") || requestParameter.getKey().equals("price")) {
                movieRequestParameters.fieldName(requestParameter.getKey());
                movieRequestParameters.sortOrder(requestParameter.getValue()[0]);
            }
        }

        return movieRequestParameters.build();
    }
}
