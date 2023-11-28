package com.example.conection.dto;



import com.example.conection.authentication.dto.UserData;
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

    private String stackTrace;
    private  String path;
    private LocalDateTime timestamp; // Timestamp for when the response was generated
    private UserData userData ; // User information

    private T dataResponse;

    private T dataRequest;

    private String exceptionMessage;

    private List detailedMessage; // Detailed error message for failures

    private String exceptionName;

    public Result() {
        this.timestamp = LocalDateTime.now();
    }

    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp, T dataResponse) {
        this(flag, code, message, timestamp);
        this.dataResponse = dataResponse;
    }

    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp,UserData userData,T dataResponse) {
        this(flag, code, message, timestamp);
        this.userData = userData;
        this.dataResponse = dataResponse;
    }

    public Result(boolean flag, Integer code, String message, LocalDateTime timestamp, UserData userData, T dataResponse, T dataRequest) {
        this(flag, code, message, timestamp);
        this.userData = userData;
        this.dataResponse = dataResponse;
        this.dataRequest = dataRequest;
    }





    public Result(boolean flag, Integer code, String message,String stackTrace,String path, LocalDateTime timestamp,UserData userData, String exceptionMessage,  String exceptionName) {
        this(flag, code, message, timestamp);
        this.path = path;
        this.stackTrace = stackTrace;
        this.userData = userData;
        this.exceptionMessage = exceptionMessage;
        this.exceptionName = exceptionName;
    }

    public Result(boolean flag, Integer code, String message,String stackTrace,String path, LocalDateTime timestamp,UserData userData,String exceptionMessage,  List detailedMessage,  String exceptionName) {
        this(flag, code, message, timestamp);
        this.path = path;
        this.stackTrace = stackTrace;
        this.userData = userData;
        this.exceptionName=exceptionMessage;
        this.detailedMessage = detailedMessage;
        this.exceptionName = exceptionName;

    }

    public Result(boolean flag, Integer code, String message,String stackTrace,String path, LocalDateTime timestamp,UserData userData, List detailedMessage,  String exceptionName) {
        this(flag, code, message, timestamp);
        this.path = path;
        this.stackTrace = stackTrace;
        this.userData = userData;
        this.detailedMessage = detailedMessage;
        this.exceptionName = exceptionName;

    }



}