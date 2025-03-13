package com.example.bank_service_api.service.implement;

import com.example.bank_service_api.model.Transaction;
import com.example.bank_service_api.repository.TransactionRepository;
import com.example.bank_service_api.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImplement implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByWalletId(Long walledId) {
        return transactionRepository.findByWalletId(walledId);
    }
}
