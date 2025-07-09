package com.email.exception;

import com.email.response.ErrorResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorResponses> responseEntity(EmailException ex){

        String message=ex.getMessage();

        ErrorResponses build = ErrorResponses.builder().message(message)
                .success(false).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(build,HttpStatus.BAD_REQUEST);
    }
}
