package com.ivandanylov.movieland.dao.utils;

import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;
import org.springframework.stereotype.Component;

@Component
public class SqlGenerator {
    public String generateMovieSortSql(String sql, MovieGetAllRequestParameters requestParameters) {
        if (requestParameters == null || !requestParameters.isSorted()) {
            return sql;
        }

        StringBuilder movieSortSql = new StringBuilder(sql);
        movieSortSql.append(" ORDER BY ");
        movieSortSql.append(requestParameters.getFieldName());
        movieSortSql.append(" ");
        movieSortSql.append(requestParameters.getSortOrder());

        return movieSortSql.toString();
    }
}
