package com.alfred.wallet;

import com.alfred.wallet.model.Customer;

public class Main {
  public static void main(String[] args) {

    Customer customer = new Customer(10001, "Alfred");

    System.out.printf("ID: %d%n", customer.getCustomerId());
    System.out.printf("Name: %s%n", customer.getName());
  }
}
