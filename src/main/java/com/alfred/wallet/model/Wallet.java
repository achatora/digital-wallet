package com.alfred.wallet.model;

import java.math.BigDecimal;

public class Wallet {
  private long walletId;
  private Customer owner;
  private Currency currency;
  private BigDecimal balance;

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

  }

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
}
