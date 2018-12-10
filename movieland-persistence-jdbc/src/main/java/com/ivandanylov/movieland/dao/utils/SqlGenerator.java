package com.ivandanylov.movieland.dao.utils;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.StringJoiner;

@Component
public class SqlGenerator {
    public String generateMovieSortSql(String sql, Map<String, String> requestParameters) {
        if (requestParameters == null || requestParameters.isEmpty()) {
            return sql;
        }

        StringBuilder movieSortSql = new StringBuilder();
        movieSortSql.append(sql.replace(";", ""));
        movieSortSql.append("\nORDER BY\n");

        StringJoiner sqlParameters = new StringJoiner(",\n");

        for (Map.Entry entry : requestParameters.entrySet()) {
            String parameterName = entry.getKey().toString().toLowerCase();
            String parameterValue = entry.getValue().toString().toUpperCase();

            sqlParameters.add(parameterName.concat(" ").concat(SortOrder.valueOf(parameterValue).toString()));
        }

        movieSortSql.append(sqlParameters);

        return movieSortSql.toString();
    }
}
