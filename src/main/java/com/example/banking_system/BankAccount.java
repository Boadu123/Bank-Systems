package com.example.banking_system;

import java.util.LinkedList;

abstract class BankAccount implements BankOperations {
    private String accountNumber;
    private String accountName;
    protected double balance;
    private LinkedList<String> transactionHistory = new LinkedList<>();

    public BankAccount(String accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You deposited" + amount);
            logTransactions(" Deposited " + accountNumber);
        } else {
            System.out.println("Your deposit didn't go through");
        }
    }

    public void deposit(double amount, String note) {
        if (amount > 0) {
            balance += amount;
            System.out.println("You deposited " + amount + ". Note: " + note);
            logTransactions("Deposited: " + amount + " | Note: " + note);
        } else {
            System.out.println("Deposit failed. Amount must be greater than 0.");
        }
    }

    protected void logTransactions(String entry){
        transactionHistory.add(entry);
    }

    public void viewLastNTransactions(int n){
        System.out.println("Last" + n + "transactions");
        int count = 0;
        for(String record: transactionHistory){
            if(count == n){
                count++;
            }
            System.out.println(record);
        }
        if(transactionHistory.isEmpty()){
            System.out.println("No transactions yet.");
        }
    }

    public void withdrawal(double amount){}

    public double accountBalance() {
        System.out.println("Your balance is " + balance);
        return balance;
    }

    public double accountBalance(String currency) {
        System.out.println("Your balance in " + currency + " is: " + balance);
        return balance;
    }


    public void withdrawal(double amount, String note) {
        System.out.println("Attempting to withdraw " + amount + " for: " + note);
        withdrawal(amount);
    }


    public String showInfo() {
        return "Account No: " + accountNumber + "\nName: " + accountName + "\nBalance: " + balance;
    }
}

