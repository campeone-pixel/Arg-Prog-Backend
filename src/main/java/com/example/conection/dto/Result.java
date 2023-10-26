package com.example.conection.dto;



import lombok.*;

import java.time.LocalDateTime;
import java.util.List;



@Getter
@Setter
@Builder
@AllArgsConstructor
public class Result<T> {

    private boolean flag; // Two values: true means success, false means not success

    private Integer code; // Status code. e.g., 200

    private String message; // Response message


    private LocalDateTime timestamp; // Timestamp for when the response was generated
    private UserData userData ; // User information

    private T data; // The response payload


    private String detailedMessage; // Detailed error message for failures

    private String exceptionDetails; // Exception details



    public Result() {
        this.timestamp = LocalDateTime.now();
    }

    // Constructor for basic format: boolean, code, message, timestamp, userData
    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;

    }

    // Constructor for basic format: boolean, code, message, timestamp, userData
    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp,UserData userData) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.userData = userData;
    }

    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp, T data) {
        this(flag, code, message, timestamp);
        this.data = data;
    }

    // Constructor for format with data: boolean, code, message, timestamp, userId, data
    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp, UserData userData, T data) {
        this(flag, code, message, timestamp, userData);
        this.data = data;
    }

    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp, String detailedMessage) {
        this(flag, code, message, timestamp);
        this.detailedMessage = String.join(", ", detailedMessage);

    }

    // Constructor for format with detailedMessage and exceptionDetails: boolean, code, message, timestamp, detailedMessage, exceptionDetails
    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp,UserData userData, String detailedMessage, String exceptionDetails) {
        this(flag, code, message, timestamp, userData);
        this.detailedMessage = String.join(", ", detailedMessage);
        this.exceptionDetails = String.join(", ", exceptionDetails);
    }



}