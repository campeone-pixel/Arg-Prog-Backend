package com.example.conection.exceptions;

import com.example.conection.authentication.services.UserDataService;
import com.example.conection.dto.Result;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final UserDataService userDataService;

    private GlobalExceptionHandler (UserDataService userDataService){
        this.userDataService=userDataService;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    Result handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {

        BindingResult bindingResult = ex.getBindingResult();
        List<String> resumenErrores = bindingResult.getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        List<ObjectError> nombreClaseErrorList = bindingResult.getAllErrors();
        String exceptionName = bindingResult.getClass().getSimpleName();
        List<String> nombreClaseError = Collections.singletonList(ex.getClass().getSimpleName());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String path = "";
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof ServletRequestAttributes) {
            path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
        }
        return new Result(false, StatusCode.INVALID_ARGUMENT, "Error",path,stackTrace, LocalDateTime.now(), userDataService.getUserData(),ex.getMessage(), resumenErrores,exceptionName);
    }

    @ExceptionHandler({EntityNotFoundException.class})

    Result  handleEntityNotFoundException(EntityNotFoundException ex,WebRequest request) {
        String exceptionName = ex.getClass().getSimpleName();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String path = "";
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof ServletRequestAttributes) {
            path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
        }
        return new Result(false, StatusCode.NOT_FOUND,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  ex.getMessage(),exceptionName);
    }

    @ExceptionHandler({UsernameNotFoundException.class})
    Result handleUsernameNotFoundException(UsernameNotFoundException ex,WebRequest request ) {
        String exceptionName = ex.getClass().getSimpleName();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String path = "";
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof ServletRequestAttributes) {
            path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
        }
        return new Result(false, StatusCode.NOT_FOUND,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  ex.getMessage(),exceptionName);
    }
    @ExceptionHandler({BadCredentialsException.class})
    Result handleUsernameNotFoundException(BadCredentialsException ex,WebRequest request ) {
        String exceptionName = ex.getClass().getSimpleName();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String path = "";
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof ServletRequestAttributes) {
            path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
        }
        return new Result(false, StatusCode.NOT_FOUND,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  ex.getMessage(),exceptionName);
    }

    @ExceptionHandler(AccessDeniedException.class)
    Result handleAccessDeniedException(AccessDeniedException ex,WebRequest request) {
        String exceptionName = ex.getClass().getSimpleName();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String path = "";
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof ServletRequestAttributes) {
            path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
        }
        return new Result(false, StatusCode.NOT_FOUND,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  ex.getMessage(),exceptionName);
    }

    @ExceptionHandler({ExpiredJwtException.class, JwtException.class})
    Result  handleJwtException(JwtException ex,WebRequest request) {
        String exceptionName = ex.getClass().getSimpleName();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String path = "";
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof ServletRequestAttributes) {
            path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
        }
        return new Result(false, StatusCode.NOT_FOUND,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  ex.getMessage(),exceptionName);
    }

    @ExceptionHandler({AuthenticationCredentialsNotFoundException.class})
    Result handleAuthenticationCredentialsNotFoundException(AuthenticationCredentialsNotFoundException ex,WebRequest request) {
        String exceptionName = ex.getClass().getSimpleName();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String path = "";
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof ServletRequestAttributes) {
            path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
        }
        return new Result(false, StatusCode.NOT_FOUND,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  ex.getMessage(),exceptionName);
    }

    @ExceptionHandler(MalformedJwtException.class)
    Result handleOtherException(MalformedJwtException ex,WebRequest request) {
        String exceptionName = ex.getClass().getSimpleName();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String path = "";
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof ServletRequestAttributes) {
            path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
        }
        return new Result(false, StatusCode.NOT_FOUND,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  ex.getMessage(),exceptionName);
    }
    @ExceptionHandler(Exception.class)
    Result handleOtherException(Exception ex,WebRequest request) {
        String exceptionName = ex.getClass().getSimpleName();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String stackTrace = sw.toString();
        String path = "";
        RequestAttributes attribs = RequestContextHolder.getRequestAttributes();
        if (attribs instanceof ServletRequestAttributes) {
            path = ((ServletRequestAttributes) attribs).getRequest().getRequestURI();
        }
        return new Result(false, StatusCode.NOT_FOUND,"Error",path,stackTrace, LocalDateTime.now(),userDataService.getUserData(),  ex.getMessage(),exceptionName);
    }



}




