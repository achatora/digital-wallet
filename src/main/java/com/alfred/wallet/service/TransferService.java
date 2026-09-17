package com.alfred.wallet.service;

import java.math.BigDecimal;
import com.alfred.wallet.model.Wallet;

public class TransferService {

  public void transfer(Wallet sender, Wallet receiver, BigDecimal transferAmount) {

    if (sender == null) {
      throw new IllegalArgumentException("Sender cannot be null");
    }

    if (receiver == null) {
      throw new IllegalArgumentException("Receiver cannot be null");
    }

    if (transferAmount == null) {
      throw new IllegalArgumentException("Transfer amount cannot be null");
    }

    if (transferAmount.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Transfer amount must be greater than zero");
    }

    if (sender.getCurrency() != receiver.getCurrency()) {
      throw new IllegalArgumentException("Currency mismatch");
    }

    if (sender == receiver) {
      throw new IllegalArgumentException("Cannot transfer to the same wallet");
    }
    sender.transferOut(transferAmount);
    receiver.transferIn(transferAmount);
  }
}
