package com.students.advice;

import com.students.exceptions.ErrorDetails;
import com.students.exceptions.GameNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@Slf4j
@ControllerAdvice
public class GameControllerExceptionAdviser extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<?> gameNotFound(GameNotFoundException e, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Not valid request", ex.getBindingResult().toString());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalError(Exception e, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
