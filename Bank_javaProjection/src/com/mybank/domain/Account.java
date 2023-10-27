package com.mybank.domain;

public class Account {
    protected double balance;

    public Account(double initBalance) {
        this.balance = initBalance;
    }

    //save money
    public void deposit(double amt) {
        balance += amt;
    }

    //draw money
    public boolean withdraw(double amt) {
        this.balance = balance - amt;
        return !((balance - amt) < 0);
    }


    public double getBalance() {

        return balance;
    }
}

