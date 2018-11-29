package com.ivandanylov.movieland.dao.jdbc.mapper;

import com.ivandanylov.movieland.config.ApplicationTestConfig;
import com.ivandanylov.movieland.config.yaml.YamlTestMovieland;
import com.ivandanylov.movieland.entity.Movie;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.sql.*;
import java.time.LocalDate;

@DisplayName("Movie row mapper test")
@SpringJUnitWebConfig
@ContextConfiguration(classes = {ApplicationTestConfig.class})
public class MovieRowMapperTest {
    private YamlTestMovieland hsqldbSqlStatements;

    @Autowired
    private void setHsqldbSqlStatements(YamlTestMovieland hsqldbSqlStatements) {
        this.hsqldbSqlStatements = hsqldbSqlStatements;
    }

    private void before() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        initDatabase();
    }

    private void after() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(hsqldbSqlStatements
                    .getMovieland()
                    .getMovie()
                    .getDropTableSql());
            connection.commit();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:mem:movieland", "SA", "");
    }

    private void initDatabase() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(hsqldbSqlStatements
                    .getMovieland()
                    .getMovie()
                    .getCreateTableSql());
            connection.commit();
            statement.executeUpdate(hsqldbSqlStatements
                    .getMovieland()
                    .getMovie()
                    .getInsertSql());
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
            ResultSet resultSet = statement.executeQuery(hsqldbSqlStatements
                    .getMovieland()
                    .getMovie()
                    .getGetAllSql());
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
}
