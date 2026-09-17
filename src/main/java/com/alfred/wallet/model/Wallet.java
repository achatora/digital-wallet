package com.alfred.wallet.model;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Wallet {

  private long walletId;
  private Customer owner;
  private Currency currency;
  private BigDecimal balance;
  private List<Transaction> transactionHistory;

  public Wallet(long walletId, Customer owner, Currency currency, BigDecimal balance) {
    this.walletId = walletId;

    if (owner == null) {
      throw new IllegalArgumentException("Owner cannot be null");
    }
    this.owner = owner;

    if (currency == null) {
      throw new IllegalArgumentException("Currency cannot be null");
    }
    this.currency = currency;

    if (balance == null) {
      throw new IllegalArgumentException("Balance cannot be null");
    }

    if (balance.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("Balance entered is negative");
    }
    this.balance = balance;
    this.transactionHistory = new ArrayList<>();
  }

  // Getters
  public long getWalletId() {
    return walletId;
  }

  public Customer getOwner() {
    return owner;
  }

  public Currency getCurrency() {
    return currency;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public List<Transaction> getTransactionHistory() {
    return List.copyOf(transactionHistory);
  }

  // Helper for account validation
  private void validateAmount(BigDecimal amount) {
    if (amount == null) {
      throw new IllegalArgumentException("Amount cannot be null");
    }
    if (amount.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Amount has to be greater than zero");
    }
  }

  // Deposit
  public void deposit(BigDecimal amount) {
    validateAmount(amount);
    this.balance = this.balance.add(amount);

    Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount);
    transactionHistory.add(transaction);
  }

  // Wthdraw
  public void withdraw(BigDecimal amount) {
    validateAmount(amount);

    if (amount.compareTo(this.balance) > 0) {
      throw new IllegalArgumentException("account balance too low, cannot withdraw");
    }
    this.balance = this.balance.subtract(amount);

    Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, amount);
    transactionHistory.add(transaction);
  }

  // TRANSFER: Transfer Out
  public void transferOut(BigDecimal amount) {
    validateAmount(amount);

    if (amount.compareTo(this.balance) > 0) {
      throw new IllegalArgumentException("account balance too low, cannot complete transfer");
    }
    this.balance = this.balance.subtract(amount);

    Transaction transaction = new Transaction(TransactionType.TRANSFER, amount);
    transactionHistory.add(transaction);
  }

  // TRANSFER: Transfer In
  public void transferIn(BigDecimal amount) {
    validateAmount(amount);
    this.balance = this.balance.add(amount);

    Transaction transaction = new Transaction(TransactionType.TRANSFER, amount);
    transactionHistory.add(transaction);
  }
}
