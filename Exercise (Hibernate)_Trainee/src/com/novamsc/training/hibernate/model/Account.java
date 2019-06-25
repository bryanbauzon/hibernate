package com.novamsc.training.hibernate.model;

import java.io.Serializable;

import com.novamsc.training.hibernate.util.AccountType;

/**
 * Domain model for Account.
 * <p>
 */
public class Account implements Serializable
{
    private long accountID;
    private int version;
//    private char type;
    private double balance;
    private Customer customer;
    private AccountType accountType;

    public Account() {

    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

//    public char getType() {
//        return type;
//    }
//
//    public void setType(char type) {
//        this.type = type;
//    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(balance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
            return false;
        return true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountTpe) {
        this.accountType = accountTpe;
    }

}
