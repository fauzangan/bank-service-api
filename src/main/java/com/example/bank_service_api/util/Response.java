package com.example.bank_service_api.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    public static <T> ResponseEntity<?> renderJSON(T data, String message, HttpStatus httpStatus){
        WebResponse<T> response = WebResponse.<T>builder()
                .message(message)
                .status(httpStatus.getReasonPhrase())
                .data(data)
                .build();
        return ResponseEntity.status(httpStatus).body(response);
    }

    public static <T> ResponseEntity<?> renderError(String message, HttpStatus httpStatus){
        ErrorResponse<T> response = ErrorResponse.<T>builder()
                .message(message)
                .statusCode(httpStatus)
                .build();
        return ResponseEntity.status(httpStatus).body(response);
    }
}
