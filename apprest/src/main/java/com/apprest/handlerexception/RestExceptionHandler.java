package com.apprest.handlerexception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(EntityNotFoundException ex){
        ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(),ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException
    (MethodArgumentNotValidException e) {

        List<FieldError> fieldErrors =  e.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

        ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
        validationErrorDetails.setStatus (HttpStatus.BAD_REQUEST.value());
        validationErrorDetails.setTitulo("Operação Inválida");
        validationErrorDetails.setMensagem("Requisição Inválida");
        validationErrorDetails.setField(fields);
        validationErrorDetails.setFieldMessage(fieldMessages);

        return new ResponseEntity<>(validationErrorDetails, HttpStatus.BAD_REQUEST);

    }

}