package com.ivandanylov.movieland.persistence.jdbc.mapper;

import com.ivandanylov.movieland.entity.Genre;
import com.ivandanylov.movieland.persistence.jdbc.TestPersistenceJdbcConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.sql.*;

@DisplayName("Genre row mapper test")
@SpringJUnitConfig(classes = {TestPersistenceJdbcConfig.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
class GenreRowMapperTest {
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
        GenreRowMapper genreRowMapper = new GenreRowMapper();

        before();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(getAllSql);
            resultSet.next();

            Genre actualGenre= genreRowMapper.mapRow(resultSet, 1);

            Assertions.assertNotNull(actualGenre);
            Assertions.assertEquals(1, actualGenre.getId());
            Assertions.assertEquals("Genre name", actualGenre.getName());
        } finally {
            after();
        }
    }

    @Value("${database.genre.createTableSql}")
    void setCreateTableSql(String createTableSql) {
        this.createTableSql = createTableSql;
    }

    @Value("${database.genre.insertSql}")
    void setInsertSql(String insertSql) {
        this.insertSql = insertSql;
    }

    @Value("${database.genre.getAllSql}")
    void setGetAllSql(String getAllSql) {
        this.getAllSql = getAllSql;
    }

    @Value("${database.genre.dropTableSql}")
    void setDropTableSql(String dropTableSql) {
        this.dropTableSql = dropTableSql;
    }
}
