package com.ivandanylov.movieland.dao.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@DisplayName("Sql generator test")
class SqlGeneratorTest {
    @Test
    void testGenerateMovieSortSql() {
        Map<String, String> requestParameters = new HashMap<>();
        requestParameters.put("price", "desc");
        requestParameters.put("rating", "asc");

        SqlGenerator sqlGenerator = new SqlGenerator();
        String resultSql = sqlGenerator.generateMovieSortSql("SELECT * FROM movie", requestParameters);

        Assertions.assertEquals("SELECT * FROM movie\nORDER BY\nprice DESC,\nrating ASC", resultSql);
    }

    @Test
    void testGenerateMovieSortSqlEmptyParameters() {
        Map<String, String> requestParameters = new HashMap<>();

        SqlGenerator sqlGenerator = new SqlGenerator();
        String resultSql = sqlGenerator.generateMovieSortSql("SELECT * FROM movie", requestParameters);

        Assertions.assertEquals("SELECT * FROM movie", resultSql);
    }

    @Test
    void testGenerateMovieSortSqlNullParameters() {
        SqlGenerator sqlGenerator = new SqlGenerator();
        String resultSql = sqlGenerator.generateMovieSortSql("SELECT * FROM movie", null);

        Assertions.assertEquals("SELECT * FROM movie", resultSql);
    }
}
