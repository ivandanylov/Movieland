package com.ivandanylov.movieland.config;

import com.ivandanylov.movieland.config.db.HKDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    private DataSource dataSource;
    private final static Logger logger = LoggerFactory.getLogger(DbConfig.class);

    public DbConfig(YamlConfig yamlConfig) {
        logger.info("[Movieland][DbConfig] Start initializing constructor");

        String driverClassName = yamlConfig
                .applicationProperties()
                .getApplication()
                .getDatabase()
                .getDriverClassName();
        String jdbcUrl = yamlConfig
                .applicationProperties()
                .getApplication()
                .getDatabase()
                .getUrlEnvironmentVariableName();

        logger.info(String.format("[DbConfig] Database properties: driverClassName = %s, yamlConfig = %s", driverClassName, jdbcUrl));

        dataSource = HKDataSource.getDataSource(driverClassName, System.getenv(jdbcUrl));

        logger.info("[Movieland][DbConfig] HKDataSource initialized");
        logger.info("[Movieland][DbConfig] End initializing DbConfig constructor");
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
