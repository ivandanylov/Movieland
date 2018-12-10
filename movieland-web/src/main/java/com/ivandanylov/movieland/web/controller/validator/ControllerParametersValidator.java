package com.ivandanylov.movieland.web.controller.validator;

import com.ivandanylov.movieland.dao.utils.SortOrder;
import com.ivandanylov.movieland.web.controller.exception.BadRequestParameterException;

import java.util.Map;

public class ControllerParametersValidator {
    public Map<String, String> validateMovieGetAll(Map<String, String> requestParameters) {
        for (Map.Entry entry : requestParameters.entrySet()) {
            String parameterName = entry.getKey().toString().toLowerCase();
            String parameterValue = entry.getValue().toString().toUpperCase();

            if (parameterName.equals("price") || parameterName.equals("rating")) {
                try {
                    SortOrder.valueOf(parameterValue);
                } catch (Exception e) {
                    throw new BadRequestParameterException(String.format("Illegal parameter value '%s'", parameterValue), e);
                }
            } else {
                throw new BadRequestParameterException(String.format("Illegal parameter name '%s'", parameterName));
            }

        }

        return requestParameters;
    }
}
