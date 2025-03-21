package com.example.bank_service_api.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawalRequest {

    @NotNull
    private Long user_id;

    @NotNull
    private String pin;

    @NotNull
    @Positive(message = "Withdrawal amount must be positive value")
    private BigDecimal amount;


}
