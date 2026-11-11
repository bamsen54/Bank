package com.simon.model;

import com.simon.exception.InsufficientFundsException;
import com.simon.exception.InvalidAmountException;

public class Account {

    private Long id;
    private double balance;


    public Account(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public double checkBalance() {
        return this.balance;
    }

    public void deposit(double amount) {

        if(amount <= 0)
            throw new InvalidAmountException("amount cannot be negative or zero");

        this.balance += amount;
    }

    public void withdraw(double amount) {

        if(amount <= 0)
            throw new InvalidAmountException("amount cannot be negative or zero");

        if(amount > this.balance)
            throw new InsufficientFundsException("withdrawal failed: Insufficient funds in the account");


        this.balance -= amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
