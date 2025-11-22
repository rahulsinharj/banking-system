package com.example.banking.controller;

import com.example.banking.model.Account;
import com.example.banking.model.Customer;
import com.example.banking.model.Transaction;
import com.example.banking.dto.TransactionRequest;
import com.example.banking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/banking")
public class BankingController {
    @Autowired
    private BankingService bankingService;

    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@RequestBody Customer customer, @RequestParam BigDecimal initialBalance) {
        return ResponseEntity.ok(bankingService.createAccount(customer, initialBalance));
    }

    @PostMapping("/transaction")
    public ResponseEntity<Transaction> performTransaction(@RequestBody TransactionRequest request) {
        return ResponseEntity.ok(bankingService.performTransaction(request.getAccountId(), request.getAmount(), request.getType()));
    }

    @GetMapping("/account/{id}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long id) {
        return ResponseEntity.ok(bankingService.getBalance(id));
    }
}
