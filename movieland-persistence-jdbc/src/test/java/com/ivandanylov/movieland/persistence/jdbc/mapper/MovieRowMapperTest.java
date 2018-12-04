package com.ivandanylov.movieland.persistence.jdbc.mapper;

import com.ivandanylov.movieland.entity.Movie;
import com.ivandanylov.movieland.persistence.jdbc.TestPersistenceJdbcConfig;
import com.ivandanylov.movieland.persistence.jdbc.config.PersistenceJdbcConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.sql.*;
import java.time.LocalDate;

@DisplayName("Movie row mapper test")
@SpringJUnitConfig(classes = {TestPersistenceJdbcConfig.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
class MovieRowMapperTest {
    private String createTableSql;
    private String insertSql;
    private String getAllSql;
    private String dropTableSql;

    private void before() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        initDatabase();
    }

    private void after() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropTableSql);
            connection.commit();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:mem:movieland", "SA", "");
    }

    private void initDatabase() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createTableSql);
            connection.commit();
            statement.executeUpdate(insertSql);
            connection.commit();
        }
    }

    @Test
    void testMapRow() throws SQLException, ClassNotFoundException {
        MovieRowMapper movieRowMapper = new MovieRowMapper();
        LocalDate localDate = LocalDate.of(1980, 4, 9);

        before();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getAllSql);
            resultSet.next();

            Movie actualMovie = movieRowMapper.mapRow(resultSet, 1);

            assert actualMovie != null;
            Assertions.assertEquals(1, actualMovie.getId());
            Assertions.assertEquals("Movie name", actualMovie.getNameRussian());
            Assertions.assertEquals("Original movie name", actualMovie.getNameNative());
            Assertions.assertEquals(localDate.getYear(), actualMovie.getYearOfRelease());
            Assertions.assertEquals(123.45, actualMovie.getPrice());
            Assertions.assertEquals(9.8, actualMovie.getRating());
            Assertions.assertEquals("https://link.com/image.jpg", actualMovie.getPicturePath());
        }

        after();
    }

    @Value("${database.movie.createTableSql}")
    void setCreateTableSql(String createTableSql) {
        this.createTableSql = createTableSql;
    }

    @Value("${database.movie.insertSql}")
    void setInsertSql(String insertSql) {
        this.insertSql = insertSql;
    }

    @Value("${database.movie.getAllSql}")
    void setGetAllSql(String getAllSql) {
        this.getAllSql = getAllSql;
    }

    @Value("${database.movie.dropTableSql}")
    void setDropTableSql(String dropTableSql) {
        this.dropTableSql = dropTableSql;
    }
}
