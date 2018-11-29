package com.ivandanylov.movieland.config;

import com.ivandanylov.movieland.config.yaml.YamlApplication;
import com.ivandanylov.movieland.config.yaml.YamlQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;


@Configuration
public class YamlConfig {
    @Bean
    public YamlApplication applicationProperties() {
        Yaml yaml = new Yaml(new Constructor(YamlApplication.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("properties/database_config.yml");

        return yaml.load(inputStream);
    }

    @Bean
    public YamlQuery queries() {
        Yaml yaml = new Yaml(new Constructor(YamlQuery.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("properties/database_query.yml");

        return yaml.load(inputStream);
    }
}
