package com.ivandanylov.movieland.persistence.jdbc.config;

import com.ivandanylov.movieland.persistence.jdbc.datasource.HKDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class PersistenceJdbcConfig {
    private final static Logger logger = LoggerFactory.getLogger(PersistenceJdbcConfig.class);
    private String driverClassName;
    private String jdbcUrl;

    @Bean
    public static PropertySourcesPlaceholderConfigurer dbProperties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("db.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public DataSource hkDataSource() {
        logger.info("[movieland] Start initializing constructor");
        logger.info(String.format("[movieland] Database properties: driverClassName = %s, jdbcUrl = %s", driverClassName, jdbcUrl));

        DataSource dataSource = HKDataSource.getDataSource(driverClassName, System.getenv(jdbcUrl));

        logger.info("[movieland] HKDataSource initialized");
        logger.info("[movieland] End initializing DbConfig constructor");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Value("${database.connection.driverClassName}")
    public void setDriverClassName(String driverClassName) {
        logger.debug(String.format("[movieland] Injected driverClassName = '%s'", driverClassName));

        this.driverClassName = driverClassName;
    }

    @Value("${database.connection.urlEnvironmentVariableName}")
    public void setJdbcUrl(String jdbcUrl) {
        logger.debug(String.format("[movieland] Injected urlEnvironmentVariableName = '%s'", jdbcUrl));

        this.jdbcUrl = jdbcUrl;
    }
}
