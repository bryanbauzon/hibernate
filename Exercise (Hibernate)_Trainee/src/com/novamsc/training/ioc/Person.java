package com.novamsc.training.ioc;

import java.io.Serializable;

/**
 * A typical Javabean class
 * 
 * @author yewfai.chan
 */
public class Person implements Serializable
{
    private String firstName;
    private String lastName;
    private Wallet wallet;

    /** Creates new Person */
    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person[firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", wallet=").append(wallet);
        sb.append("]");
            
        return sb.toString();
    }    
}
