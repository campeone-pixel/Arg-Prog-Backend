package com.example.conection.exceptions;

import com.example.conection.Servicios.UserDataService;
import com.example.conection.dto.Result;
import com.example.conection.dto.UserData;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;


import java.time.LocalDateTime;
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
        return new Result(false, StatusCode.INVALID_ARGUMENT, "Error", LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result  handleEntityNotFoundException(EntityNotFoundException ex) {

        return new Result(false, StatusCode.UNAUTHORIZED,"Error", LocalDateTime.now(),  ex.getMessage());
    }



    @ExceptionHandler({UsernameNotFoundException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleUsernameNotFoundException(UsernameNotFoundException ex ) {

        return new Result(false, StatusCode.UNAUTHORIZED, "Error", LocalDateTime.now(),   ex.getMessage());}

    @ExceptionHandler({BadCredentialsException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleUsernameNotFoundException(BadCredentialsException ex ) {

        return new Result(false, StatusCode.FORBIDDEN, "Error", LocalDateTime.now(),  ex.getMessage());
    }


    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    Result handleAccessDeniedException(AccessDeniedException ex) {

        return new Result(false, StatusCode.FORBIDDEN, "Error", LocalDateTime.now(),  ex.getMessage());
    }

    @ExceptionHandler({ExpiredJwtException.class, JwtException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result  handleJwtException(JwtException ex) {

        return new Result(false, StatusCode.UNAUTHORIZED, "Error", LocalDateTime.now(),  ex.getMessage());
    }

    @ExceptionHandler({AuthenticationCredentialsNotFoundException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result handleAuthenticationCredentialsNotFoundException(AuthenticationCredentialsNotFoundException ex) {

        return new Result(false, StatusCode.UNAUTHORIZED, "Error", LocalDateTime.now(), ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    Result handleOtherException(Exception ex) {

        return new Result(false, StatusCode.INTERNAL_SERVER_ERROR, "Error", LocalDateTime.now(),  ex.getMessage());
    }



}




