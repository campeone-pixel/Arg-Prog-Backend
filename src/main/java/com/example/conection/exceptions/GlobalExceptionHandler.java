package com.example.conection.exceptions;



import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.NoHandlerFoundException;


import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    Result handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        Set<String> resumenErrores = bindingResult.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toSet());


        return new Result(false, StatusCode.INVALID_ARGUMENT, "INVALIDO.", resumenErrores);
    }

    @ExceptionHandler({ExpiredJwtException.class, JwtException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result  handleJwtException(JwtException ex) {

        return new Result(false, StatusCode.UNAUTHORIZED, "Invalid or expired JWT token.", ex.getMessage());
    }


    @ExceptionHandler({UsernameNotFoundException.class, BadCredentialsException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleAuthenticationException(Exception ex) {
        return new Result(false, StatusCode.UNAUTHORIZED, "username or password is incorrect.", ex.getMessage());
    }


    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    Result handleAccessDeniedException(AccessDeniedException ex) {
        return new Result(false, StatusCode.FORBIDDEN, "No permission.", ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    Result handleOtherException(Exception ex) {
        return new Result(false, StatusCode.INTERNAL_SERVER_ERROR, "A server internal error occurs.", ex.getMessage());
    }


    private String resumirErroresDeValidacion(List<FieldError> errors) {
        StringBuilder resumen = new StringBuilder("Errores de validación:\n");

        for (FieldError error : errors) {
            resumen.append("- Campo: ").append(error.getField());
            resumen.append(", Valor rechazado: ").append(error.getRejectedValue());
            resumen.append(", Error: ").append(error.getDefaultMessage());
            resumen.append("\n");
        }

        return resumen.toString();
    }
}




