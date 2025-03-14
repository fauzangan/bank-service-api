package com.example.bank_service_api.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ErrorResponse<T> {
    private HttpStatus statusCode;
    private String message;
}
