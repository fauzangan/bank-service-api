package com.example.bank_service_api.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class WebResponse<T> {
    private String message;
    private String status;
    private T data;
}
