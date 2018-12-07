package com.ivandanylov.movieland.dao.jdbc.config;

import com.ivandanylov.movieland.dao.jdbc.datasource.HKDataSource;
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
        yaml.setResources(new ClassPathResource("dao.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public DataSource hkDataSource() {
        logger.debug("Database properties: driverClassName = '{}', jdbcUrl = '{}'", driverClassName, jdbcUrl);

        DataSource dataSource = HKDataSource.getDataSource(driverClassName, System.getenv(jdbcUrl));

        logger.info("HKDataSource initialized");

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

    @Value("${dao.connection.driverClassName}")
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Value("${dao.connection.urlEnvironmentVariableName}")
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
