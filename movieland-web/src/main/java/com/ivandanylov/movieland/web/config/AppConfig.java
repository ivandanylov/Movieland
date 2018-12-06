package com.ivandanylov.movieland.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ivandanylov.movieland"},
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "com\\.ivandanylov\\.movieland\\.controller\\..*")})
public class AppConfig {
}
