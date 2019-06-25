package com.novamsc.training.ioc;

public class SavingAccount
{
    private long accountNo;
    private double balance;
    
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public SavingAccount() {
        // TODO Auto-generated constructor stub
    }
    
    public SavingAccount(long accountNo) {
        this.accountNo = accountNo;
        // TODO Auto-generated constructor stub
    }

}
