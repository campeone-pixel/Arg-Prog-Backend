package com.example.conection.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private ZonedDateTime timestamp;
    private String message;
    private String error;
    private String path;

    public ExceptionResponse(String message, String error) {
        this.timestamp = ZonedDateTime.now();
        this.message = message;
        this.error = error;
        this.path = getCurrentRequestPath();
    }

    private String getCurrentRequestPath() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return requestAttributes.getRequest().getRequestURI();
    }
}