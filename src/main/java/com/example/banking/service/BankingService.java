package com.example.banking.service;

import com.example.banking.model.*;
import com.example.banking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class BankingService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Account createAccount(Customer customer, BigDecimal initialBalance) {
        Customer savedCustomer = customerRepository.save(customer);
        Account account = new Account();
        account.setCustomer(savedCustomer);
        account.setBalance(initialBalance);
        account.setAccountNumber("ACC" + System.currentTimeMillis());
        return accountRepository.save(account);
    }

    @Transactional
    public Transaction performTransaction(Long accountId, BigDecimal amount, TransactionType type) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (type == TransactionType.WITHDRAWAL && account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds");
        }

        if (type == TransactionType.WITHDRAWAL) {
            account.setBalance(account.getBalance().subtract(amount));
        } else if (type == TransactionType.DEPOSIT) {
            account.setBalance(account.getBalance().add(amount));
        }

        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setType(type);
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    public BigDecimal getBalance(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return account.getBalance();
    }
}
