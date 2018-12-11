package com.ivandanylov.movieland.web.config;

import com.ivandanylov.movieland.web.controller.request.parameters.argumentresolver.MovieGetAllRequestParametersArgumentResolver;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ivandanylov.movieland.web.controller")
public class DispatcherConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new MovieGetAllRequestParametersArgumentResolver());
    }


}
