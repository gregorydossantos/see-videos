package com.fiap.gregory.seevideos.app.exception;

import com.fiap.gregory.seevideos.domain.exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class SeeVideoExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> badRequestException(BadRequestException ex) {
        StandardError error = new StandardError(LocalDateTime.now(), BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(BAD_REQUEST).body(error);
    }

}
