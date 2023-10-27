package com.mybank.domain;

public class Bank {

    private static Customer[] customers;
    private static int numberOfCustomers;

    static{
        customers = new Customer[10];
        numberOfCustomers = 0;
    }
    public static void addCustomer(String firstName,String lastName){
        customers[numberOfCustomers++] = new Customer(firstName,lastName);
    }

    static public int getNumberOfCustomers(){
        return numberOfCustomers;
    }
    public static Customer getCustomer(int index){
        return customers[index];

    }

}
