package com.example.bank_service_api.service;

import com.example.bank_service_api.dto.WithdrawalRequest;
import com.example.bank_service_api.model.Transaction;
import com.example.bank_service_api.model.Wallet;

import java.math.BigDecimal;

public interface WalletService {
    BigDecimal getBalance(Long userId);
    Transaction withdraw(WithdrawalRequest withdrawalRequest);
    Wallet findWalletByUserId(Long userId);
}
