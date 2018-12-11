package com.ivandanylov.movieland.dao.utils;

import com.ivandanylov.movieland.request.parameters.MovieGetAllRequestParameters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Sql generator test")
class SqlGeneratorTest {
    @Test
    void testGenerateMovieSortSql() {
        MovieGetAllRequestParameters requestParameters = new MovieGetAllRequestParameters.Builder()
                .fieldName("price")
                .sortOrder("desc")
                .build();

        SqlGenerator sqlGenerator = new SqlGenerator();
        String resultSql = sqlGenerator.generateMovieSortSql("SELECT * FROM movie", requestParameters);

        Assertions.assertEquals("SELECT * FROM movie ORDER BY price DESC", resultSql);
    }

    @Test
    void testGenerateMovieSortSqlNullParameters() {
        SqlGenerator sqlGenerator = new SqlGenerator();
        String resultSql = sqlGenerator.generateMovieSortSql("SELECT * FROM movie", null);

        Assertions.assertEquals("SELECT * FROM movie", resultSql);
    }
}
