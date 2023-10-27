package com.mybank.test;

import com.mybank.domain.*;

import java.util.Scanner;

public class TestBanking {


    public static void main(String[] args) {

        Customer customer;
        Bank.addCustomer("Tom", "Green");
        //bank has been inited
        customer = Bank.getCustomer(0);
        //source blance is 1000
        customer.addAccount(1000);

        Bank.addCustomer("Marry", "White");
        customer = Bank.getCustomer(1);
        //has balance and interestrate
        customer.addAccount(new SavingAccount(5000, 0.05));
        //has balance and overdraftAmount
        customer.addAccount(new CheckingAccount(10000, 5000));

        Bank.addCustomer("Jack", "Wilson");
        customer = Bank.getCustomer(2);
        customer.addAccount(new CheckingAccount(50000, 20000));

        //input amount

        for (int customerIndex = 0; customerIndex < Bank.getNumberOfCustomers(); customerIndex++) {
            customer = Bank.getCustomer(customerIndex);
            System.out.println(customer);

            String accountType = "";
            for (int accountIndex = 0; accountIndex < customer.getNumberOfAccounts(); accountIndex++) {
                Account account = customer.getAccount(accountIndex);
                if (account instanceof SavingAccount) {
                    accountType = "SavingAccount";
                    outPutAndWithdraw(accountType, customer, accountIndex);
                } else if (account instanceof CheckingAccount) {
                    accountType = "CheckingAccount";
                    outPutAndWithdraw(accountType, customer, accountIndex);
                } else {
                    accountType = "Unknown Type";
                    outPutAndWithdraw(accountType, customer, accountIndex);
                }

            }


        }
    }

    public static boolean outPutAndWithdraw(String accountType, Customer customer, int index) {
        Scanner input = new Scanner(System.in);
        Account account = customer.getAccount(index);
        //savingAccount
        if ("SavingAccount".equals(accountType)) {
            SavingAccount savingAccount = (SavingAccount) account;
            System.out.println("账户类型：" + accountType);
            //calculate interest
            ((SavingAccount) account).accumulateInterest();
            System.out.println("目前账户余额：" + customer.getAccount(index).getBalance());
            System.out.println("Please input withdrawal amount");
            double amount = input.nextDouble();
            if (amount > savingAccount.getBalance()) {
                System.out.println("余额不足，取款失败");
                return false;
            }
            savingAccount.withdraw(amount);
            System.out.println("目前账户余额：" + savingAccount.getBalance());
            System.out.println("-------------------------------------------------");


            //checkingAccount
        } else if ("CheckingAccount".equals(accountType)) {
            CheckingAccount checkingAccount = (CheckingAccount) account;
            System.out.println("账户类型：" + accountType);
            System.out.println("目前账户余额：" + customer.getAccount(index).getBalance());
            System.out.println("可透支额度：" + checkingAccount.getOverdraftAmount());
            System.out.println("Please input withdrawal amount");
            double amount = input.nextDouble();
            if (amount > checkingAccount.getBalance() + checkingAccount.getOverdraftAmount()) {
                System.out.println("余额不足，取款失败");
                return false;
            } else if (amount >= checkingAccount.getBalance() && amount <= checkingAccount.getBalance() + checkingAccount.getOverdraftAmount()) {
                checkingAccount.withdraw(amount, checkingAccount.getOverdraftAmount());
                System.out.println("账户余额：0");
                System.out.println("剩余可透支额度为：" + checkingAccount.getOverdraftAmount());
                System.out.println("-------------------------------------------------");
            } else {
                //calculate
                checkingAccount.withdraw(amount);
                System.out.println("目前账户余额：" + checkingAccount.getBalance());
            }


            //unknownType
        } else {
            System.out.println("账户类型：" + accountType);
            System.out.println("目前账户余额：" + customer.getAccount(index).getBalance());
            System.out.println("Please input withdrawal amount");
            //calculate
            double amount = input.nextDouble();
            if (amount > account.getBalance()) {
                System.out.println("余额不足，取款失败");
                return false;
            }
            account.withdraw(amount);
            System.out.println("目前账户余额：" + account.getBalance());
            System.out.println("-------------------------------------------------");
        }
        return true;

    }
}
