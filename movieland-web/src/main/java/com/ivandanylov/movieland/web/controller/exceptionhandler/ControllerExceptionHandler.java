package com.ivandanylov.movieland.web.controller.exceptionhandler;

import com.ivandanylov.movieland.service.exception.BadRequestParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    private final static String BAD_REQUEST_MESSAGE = "Bad Request parameters";

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = BAD_REQUEST_MESSAGE)
    @ExceptionHandler(BadRequestParameterException.class)
    public ResponseEntity<?> handleIllegalArgumentException(Exception e) {
        logger.error("Error: ", e);

        return ResponseEntity.badRequest().build();
    }
}
