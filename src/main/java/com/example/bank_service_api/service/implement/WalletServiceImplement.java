package com.example.bank_service_api.service.implement;

import com.example.bank_service_api.dto.TransactionResponse;
import com.example.bank_service_api.dto.WalletBalanceResponse;
import com.example.bank_service_api.dto.WithdrawalRequest;
import com.example.bank_service_api.exception.IncorrectPINNumberException;
import com.example.bank_service_api.exception.InsufficientBalanceException;
import com.example.bank_service_api.exception.ResourceNotFoundException;
import com.example.bank_service_api.model.*;
import com.example.bank_service_api.repository.WalletRepository;
import com.example.bank_service_api.service.TransactionService;
import com.example.bank_service_api.service.UserService;
import com.example.bank_service_api.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletServiceImplement implements WalletService {
    private final UserService userService;
    private final WalletRepository walletRepository;
    private final TransactionService transactionService;

    @Override
    public WalletBalanceResponse getBalance(Long userId) {
        Wallet wallet = findWalletByUserId(userId);
        return WalletBalanceResponse.builder()
                .wallet_id(wallet.getId())
                .balance(wallet.getBalance())
                .build();
    }

    @Override
    public TransactionResponse withdraw(WithdrawalRequest withdrawalRequest) {
        Wallet wallet = findWalletByUserId(withdrawalRequest.getUser_id());
        BigDecimal amount = withdrawalRequest.getAmount();

        if (!wallet.getPin().equals(withdrawalRequest.getPin())){
            throw new IncorrectPINNumberException("PIN is Incorrect");
        }

        if (wallet.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal");
        }

        wallet.setBalance(wallet.getBalance().subtract(amount));
        Wallet savedWallet = walletRepository.save(wallet);

        Transaction newTransaction = Transaction.builder()
                .wallet(wallet)
                .amount(amount)
                .type(TransactionType.WITHDRAWAL)
                .status(TransactionStatus.COMPLETED)
                .build();

        Transaction savedTransaction = transactionService.saveTransaction(newTransaction);
        return TransactionResponse.builder()
                .transaction_id(savedTransaction.getId())
                .user_id(savedTransaction.getWallet().getUser().getId())
                .amount(amount)
                .updated_balance(savedWallet.getBalance())
                .timestamp(savedTransaction.getCreatedAt())
                .build();
    }

    @Override
    public Wallet findWalletByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return walletRepository.findByUser(user).orElseThrow(
                () -> new ResourceNotFoundException("Wallet not found for user with id:" + user.getId())
        );
    }
}
