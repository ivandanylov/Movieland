package com.ivandanylov.movieland.web.controller.exception;

public class BadRequestParameterException extends RuntimeException {
    public BadRequestParameterException(String message) {
        super(message);
    }

    public BadRequestParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
