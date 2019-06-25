package com.novamsc.training.hibernate.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A domain model representing a customer.
 * <p>
 * 
 * @author yewfai.chan
 */
public class Customer implements Serializable
{
    private long customerID;
    private int version;
    private String lastName;
    private String firstName;
    private Address address;
    private Set<Account> accounts = new HashSet<Account>();
    private Account accountGetter;
    private Set<LoanAccount> loanAccounts = new HashSet<LoanAccount>();
    // private

    public Customer() {

    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account to be added must not be null!");
        }
        account.setCustomer(this);
        accounts.add(account);
    }

    public void removeAttachment(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account to be removed must not be null!");
        }
        accounts.remove(account);

    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<LoanAccount> getLoanAccounts() {
        return loanAccounts;
    }

    public void setLoanAccounts(Set<LoanAccount> loanAccounts) {
        this.loanAccounts = loanAccounts;
    }

    public void addLoanAccount(LoanAccount loanAccount) {
        if (loanAccount == null) {
            throw new IllegalArgumentException("Loan Account to be added must not be null!");
        }
        loanAccount.setCustomer(this);
        loanAccounts.add(loanAccount);
    }

}
