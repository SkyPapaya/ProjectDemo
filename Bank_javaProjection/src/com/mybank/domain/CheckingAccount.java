package com.mybank.domain;

public class CheckingAccount extends Account {

    private double overdraftAmount;

    public CheckingAccount(double initBalance, double overdraftAmount) {
        super(initBalance);
        this.overdraftAmount = overdraftAmount;

    }

    public CheckingAccount(int initBalance) {
        super(initBalance);
        this.overdraftAmount = 0.0;

    }

    public double getOverdraftAmount() {
        return overdraftAmount;
    }


    public boolean withdraw(double amount, double overdraftAmount) {
        boolean flag = true;
        if (balance < amount) {
            double overdraftNeed = amount - balance;
            if (overdraftAmount < overdraftNeed) {
                System.out.println("允许透支的额度不足，交易失败");
                flag = false;
            } else {
                //存款变为0并且透支额度减少被透支的钱
                balance = 0.0;
                this.overdraftAmount -= overdraftNeed;
            }
        } else {
            balance -= amount;

        }
        return flag;
    }


}
