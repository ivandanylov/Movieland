package com.ivandanylov.movieland.config.yaml;

import com.ivandanylov.movieland.config.YamlConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntYamlConfigTest {

    @Test
    void applicationProperties() {
        YamlConfig yamlConfig = new YamlConfig();

        Assertions.assertEquals("org.postgresql.Driver",
                yamlConfig
                        .applicationProperties()
                        .getApplication()
                        .getDatabase()
                        .getDriverClassName());
        Assertions.assertEquals("JDBC_DATABASE_URL",
                yamlConfig
                        .applicationProperties()
                        .getApplication()
                        .getDatabase()
                        .getUrlEnvironmentVariableName());
        Assertions.assertEquals("SELECT\n" +
                        "  id,\n" +
                        "  name,\n" +
                        "  original_name,\n" +
                        "  issue_date,\n" +
                        "  rating,\n" +
                        "  price,\n" +
                        "  poster_link\n" +
                        "FROM\n" +
                        "    movieland.movie;",
                yamlConfig.queries()
                        .getGetAllMovies());
    }
}