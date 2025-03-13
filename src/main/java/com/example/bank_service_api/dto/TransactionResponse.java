package com.example.bank_service_api.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Builder
public class TransactionResponse {
    private Long transaction_id;
    private Long user_id;
    private BigDecimal amount;
    private BigDecimal updated_balance;
    private LocalDateTime timestamp;
}
