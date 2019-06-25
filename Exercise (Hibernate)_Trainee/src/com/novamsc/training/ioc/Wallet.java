package com.novamsc.training.ioc;

/**
 * A Javabean
 * 
 * @author yewfai.chan
 */
public class Wallet
{
    private double money;

    
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wallet[money=").append(money);
        sb.append("]");
            
        return sb.toString();
    }            
}
