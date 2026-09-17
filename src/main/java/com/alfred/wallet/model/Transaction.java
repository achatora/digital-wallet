package com.alfred.wallet.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

  private TransactionType type;
  private BigDecimal amount;
  private LocalDateTime timestamp;

  public Transaction(TransactionType type, BigDecimal amount) {

    if (type == null) {
      throw new IllegalArgumentException("Transaction type cannot be null");
    }
    this.type = type;

    if (amount == null) {
      throw new IllegalArgumentException("Transaction amount cannot be null");
    }
    if (amount.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Transaction amount has to be greater than zero");
    }
    this.amount = amount;
    this.timestamp = LocalDateTime.now();
  }

  public TransactionType getType() {
    return type;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }
}
