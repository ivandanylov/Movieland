package com.ivandanylov.movieland.config;

import com.ivandanylov.movieland.config.yaml.YamlTestMovieland;
import com.ivandanylov.movieland.dao.jdbc.JdbcMovieDao;
import com.ivandanylov.movieland.service.impl.DefaultMovieService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

@Configuration
@ComponentScan(basePackages = {"com.ivandanylov.movieland"}, excludeFilters={
        @ComponentScan.Filter(type= FilterType.ANNOTATION, classes= Repository.class)})
public class ApplicationTestConfig {
    @Bean
    public YamlTestMovieland hsqldbSqlStatements() {
        Yaml yaml = new Yaml(new Constructor(YamlTestMovieland.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("hsqldb.yml");

        return yaml.load(inputStream);
    }

    @Bean
    public JdbcMovieDao movieDao() {
        return Mockito.mock(JdbcMovieDao.class);
    }

    @Bean
    public DefaultMovieService movieService() {
        return Mockito.mock(DefaultMovieService.class);
    }
}
