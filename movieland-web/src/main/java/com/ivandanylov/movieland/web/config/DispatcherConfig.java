package com.ivandanylov.movieland.web.config;

import com.ivandanylov.movieland.web.controller.exceptionhandler.ControllerExceptionHandler;
import com.ivandanylov.movieland.web.controller.validator.ControllerParametersValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ivandanylov.movieland.web.controller")
public class DispatcherConfig {
    @Bean
    ControllerParametersValidator controllerParametersValidator() {
        return new ControllerParametersValidator();
    }
}
