package com.alfred.wallet.repository;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import com.alfred.wallet.model.Wallet;

public class WalletRepository {
  private Map<Long, Wallet> wallets = new HashMap<>();

  public void save(Wallet wallet) {
    if (wallet == null) {
      throw new IllegalArgumentException("Wallet cannot be null");
    }

    if (wallets.containsKey(wallet.getWalletId())) {
      throw new IllegalArgumentException("This id already exists");
    }

    wallets.put(wallet.getWalletId(), wallet);
  }

  public Optional<Wallet> findById(long walletId) {
    return Optional.ofNullable(wallets.get(walletId));
  }

  public List<Wallet> findAll() {
    List<Wallet> allWallets = new ArrayList<>(wallets.values());
    return allWallets;
  }
}
