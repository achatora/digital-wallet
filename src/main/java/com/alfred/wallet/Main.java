package com.alfred.wallet;

import java.math.BigDecimal;

import com.alfred.wallet.model.Currency;
import com.alfred.wallet.model.Customer;
import com.alfred.wallet.model.Wallet;
import com.alfred.wallet.service.TransferService;

public class Main {
  public static void main(String[] args) {

    // Customer creation
    Customer customer = new Customer(10001, "Alfred");
    Customer customer2 = new Customer(10002, "John");

    System.out.printf("ID: %d%n", customer.getCustomerId());
    System.out.printf("Name: %s%n", customer.getName());

    // Wallet creation
    Wallet wallet = new Wallet(20001, customer, Currency.EUR, new BigDecimal("100.00"));
    Wallet wallet2 = new Wallet(20002, customer2, Currency.EUR, new BigDecimal("50.00"));
    System.out.println(wallet.getOwner().getName());
    System.out.println(wallet2.getOwner().getName());

    // Deposit
    wallet.deposit(new BigDecimal("50.00"));
    System.out.printf("Deposit success! New wallet balance: %s %.2f%n", wallet.getCurrency(), wallet.getBalance());

    // Withdrawal
    wallet.withdraw(new BigDecimal("40.00"));
    System.out.printf("Withdrawal success! New wallet balance: %s %.2f%n", wallet.getCurrency(), wallet.getBalance());

    // Transfer
    TransferService transfer = new TransferService();
    transfer.transfer(wallet, wallet2, new BigDecimal("40.00"));

    // New account balances after Transfer
    System.out.printf("Account Name: %s | New balance: %s%n", customer.getName(), wallet.getBalance());
    System.out.printf("Account Name: %s | New balance: %s%n", customer2.getName(), wallet2.getBalance());
  }
}
