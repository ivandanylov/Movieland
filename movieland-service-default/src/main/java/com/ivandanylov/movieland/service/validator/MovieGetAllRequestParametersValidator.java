package com.ivandanylov.movieland.service.validator;

import com.ivandanylov.movieland.enums.SortOrder;
import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;
import com.ivandanylov.movieland.service.api.MovieValidatorService;
import com.ivandanylov.movieland.service.exception.BadRequestParameterException;
import org.springframework.stereotype.Service;

@Service
public class MovieGetAllRequestParametersValidator implements MovieValidatorService
{
    @Override
    public void validateRequestParameters(MovieGetAllRequestParameters requestParameters) {
        if (!requestParameters.isSorted()) {
            return;
        }

        String fieldName = requestParameters.getFieldName();
        SortOrder sortOrder = requestParameters.getSortOrder();

        if (fieldName.equals("price") || fieldName.equals("rating")) {
            if(fieldName.equals("rating") && sortOrder == SortOrder.ASC) {
                throw new BadRequestParameterException(String.format("Illegal parameter value '%s'", sortOrder));
            }
        } else {
            throw new BadRequestParameterException(String.format("Illegal parameter name '%s'", fieldName));
        }
    }
}
