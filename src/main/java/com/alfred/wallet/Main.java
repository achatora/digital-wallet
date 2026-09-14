package com.alfred.wallet;

import java.math.BigDecimal;

import com.alfred.wallet.model.Currency;
import com.alfred.wallet.model.Customer;
import com.alfred.wallet.model.Wallet;

public class Main {
  public static void main(String[] args) {

    Customer customer = new Customer(10001, "Alfred");

    System.out.printf("ID: %d%n", customer.getCustomerId());
    System.out.printf("Name: %s%n", customer.getName());

    Wallet wallet = new Wallet(20001, customer, Currency.EUR, new BigDecimal("100.00"));
    System.out.println(wallet.getOwner().getName());
  }
}
