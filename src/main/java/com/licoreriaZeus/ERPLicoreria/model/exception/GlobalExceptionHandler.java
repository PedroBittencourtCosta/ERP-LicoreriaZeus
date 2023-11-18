package com.licoreriaZeus.ERPLicoreria.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleProductAlreadyExists(ProductAlreadyExistsException exception, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false)));
    }

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionResponse> handleProductNotExists(ProductNotExistsException exception, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false)));
    }

    @ExceptionHandler(SubTypeNotExistsException.class)
    public ResponseEntity<ExceptionResponse> handleSubTypeNotExists(SubTypeNotExistsException exception, WebRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false)));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException exception, WebRequest request){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false)));
    }


}
