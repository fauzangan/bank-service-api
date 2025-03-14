package com.example.bank_service_api.config;

import com.example.bank_service_api.model.*;
import com.example.bank_service_api.repository.TransactionRepository;
import com.example.bank_service_api.repository.UserRepository;
import com.example.bank_service_api.repository.WalletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DatabaseSeeder {

    @Bean
    @Transactional
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   WalletRepository walletRepository,
                                   TransactionRepository transactionRepository) {
        return args -> {
            if (userRepository.count() > 0) {
                System.out.println("Database already have data.");
                return;
            }

            System.out.println("Running database seeder...");

            User user1 = User.builder()
                    .username("johndoe")
                    .email("johndoe@example.com")
                    .build();

            User user2 = User.builder()
                    .username("janedoe")
                    .email("janedoe@example.com")
                    .build();

            userRepository.saveAll(List.of(user1, user2));

            Wallet wallet1 = Wallet.builder()
                    .user(user1)
                    .pin("1234")
                    .balance(new BigDecimal("500.00"))
                    .lastUpdated(LocalDateTime.now())
                    .build();

            Wallet wallet2 = Wallet.builder()
                    .user(user2)
                    .pin("5678")
                    .balance(new BigDecimal("1000.00"))
                    .lastUpdated(LocalDateTime.now())
                    .build();

            walletRepository.saveAll(List.of(wallet1, wallet2));

            Transaction transaction1 = Transaction.builder()
                    .wallet(wallet1)
                    .amount(new BigDecimal("100.00"))
                    .type(TransactionType.DEPOSIT)
                    .status(TransactionStatus.COMPLETED)
                    .createdAt(LocalDateTime.now())
                    .build();

            Transaction transaction2 = Transaction.builder()
                    .wallet(wallet2)
                    .amount(new BigDecimal("50.00"))
                    .type(TransactionType.WITHDRAWAL)
                    .status(TransactionStatus.COMPLETED)
                    .createdAt(LocalDateTime.now())
                    .build();

            transactionRepository.saveAll(List.of(transaction1, transaction2));

            System.out.println("Database seeded successfully!");
        };
    }
}