package com.example.bank_service_api.service;

import com.example.bank_service_api.dto.TransactionResponse;
import com.example.bank_service_api.dto.WalletBalanceResponse;
import com.example.bank_service_api.dto.WithdrawalRequest;
import com.example.bank_service_api.model.Transaction;
import com.example.bank_service_api.model.Wallet;

import java.math.BigDecimal;

public interface WalletService {
    WalletBalanceResponse getBalance(Long userId);
    TransactionResponse withdraw(WithdrawalRequest withdrawalRequest);
    Wallet findWalletByUserId(Long userId);
}
