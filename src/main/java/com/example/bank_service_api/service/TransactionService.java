package com.example.bank_service_api.service;

import com.example.bank_service_api.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> getTransactionsByWalletId(Long walledId);
}
