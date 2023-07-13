package com.dans.job.common;

import com.dans.job.exception.ExternalSystemException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = { ExternalSystemException.class })
    public ResponseEntity<ErrorMessage> externalSystemException(ExternalSystemException exception) {
        return ResponseEntity.status(exception.getStatusCode()).body(
                ErrorMessage
                        .builder()
                        .message(exception.getMessage())
                        .build()
        );
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<ErrorMessage> generalException(Exception exception) {
        return ResponseEntity.internalServerError().body(
                ErrorMessage
                        .builder()
                        .message(exception.getMessage())
                        .build()
        );
    }

}
