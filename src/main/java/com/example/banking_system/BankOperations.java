package com.example.banking_system;

public interface BankOperations {
    void deposit(double amount);
    void withdrawal(double amount);
    double accountBalance();
    String showInfo();
}
