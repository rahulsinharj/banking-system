package com.example.banking.dto;

import com.example.banking.model.TransactionType;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransactionRequest {
    private Long accountId;
    private BigDecimal amount;
    private TransactionType type;
}
