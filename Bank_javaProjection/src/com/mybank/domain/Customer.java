package com.mybank.domain;

public class Customer {
    private String firstName;
    private String lastName;
    //一个用户可以有多个账户
    private Account[] accounts;
    private int numberOfAccounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //看看能否改进
        accounts = new Account[10];
        numberOfAccounts = 0;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(double amount) {
        accounts[numberOfAccounts++] = new Account(amount);
    }

    public void addAccount(Account account) {
        accounts[numberOfAccounts++] = account;
    }

    public int getNumberOfAccounts() {
        return numberOfAccounts;
    }

    //return index of account
    public Account getAccount(int index) {
        return accounts[index];
    }

    public String toString() {
        System.out.print("UserName:" + firstName + " " + lastName);
        return " ";

    }

}
