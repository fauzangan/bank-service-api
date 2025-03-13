package com.example.bank_service_api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
public class WalletBalanceResponse {
    private Long wallet_id;
    private BigDecimal balance;
}
