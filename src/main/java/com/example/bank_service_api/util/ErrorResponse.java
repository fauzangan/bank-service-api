package com.example.bank_service_api.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ErrorResponse<T> {
    private String statusCode;
    private String message;
    private T error;
}
