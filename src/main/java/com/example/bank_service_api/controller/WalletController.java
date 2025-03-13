package com.example.bank_service_api.controller;

import com.example.bank_service_api.dto.WithdrawalRequest;
import com.example.bank_service_api.service.WalletService;
import com.example.bank_service_api.util.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @GetMapping("/balance/{userId}")
    public ResponseEntity<?> getBalance(
            @PathVariable Long userId
    ){
        return Response.renderJSON(
                walletService.getBalance(userId),
                "Success get balance",
                HttpStatus.OK
        );
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(
            @Valid @RequestBody WithdrawalRequest request
    ) {
        return Response.renderJSON(
                walletService.withdraw(request),
                "Success withdraw account",
                HttpStatus.OK
        );
    }
}
