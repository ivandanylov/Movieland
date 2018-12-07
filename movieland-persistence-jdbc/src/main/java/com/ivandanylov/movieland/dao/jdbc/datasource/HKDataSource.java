package com.ivandanylov.movieland.dao.jdbc.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class HKDataSource {
    private static HikariConfig config = new HikariConfig();

    private HKDataSource() {
    }

    public static DataSource getDataSource(String driverClassName, String jdbcUrl) {
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(jdbcUrl);

        return new HikariDataSource(config);
    }
}
