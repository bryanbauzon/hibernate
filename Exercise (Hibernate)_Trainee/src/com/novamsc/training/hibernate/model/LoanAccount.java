package com.novamsc.training.hibernate.model;

import java.util.Date;

public class LoanAccount
{
    private long loanAccountId;
    private int version;
    private String loanAccountNo;
    private char loanType;
    private double amount;
    private Date loanDate;
    private Customer customer;
    private Guarantor guarantor;
    
    
    
    public LoanAccount() {
        
    }
    public long getLoanAccountId() {
        return loanAccountId;
    }
    public void setLoanAccountId(long loanAccountId) {
        this.loanAccountId = loanAccountId;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public String getLoanAccountNo() {
        return loanAccountNo;
    }
    public void setLoanAccountNo(String loanAccountNo) {
        this.loanAccountNo = loanAccountNo;
    }
    public char getLoanType() {
        return loanType;
    }
    public void setLoanType(char loanType) {
        this.loanType = loanType;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Date getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Guarantor getGuarantor() {
        return guarantor;
    }
    public void setGuarantor(Guarantor guarantor) {
        this.guarantor = guarantor;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((loanAccountNo == null) ? 0 : loanAccountNo.hashCode());
        result = prime * result + loanType;
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
        LoanAccount other = (LoanAccount) obj;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        if (loanAccountNo == null) {
            if (other.loanAccountNo != null)
                return false;
        } else if (!loanAccountNo.equals(other.loanAccountNo))
            return false;
        if (loanType != other.loanType)
            return false;
        return true;
    }
    
    
    
    
    
    
    
    
    
    
   /* private Guarantor guarantor;
    private Customer customer;
    */
    
    
    /*public long getLoanAccountId() {
        return loanAccountId;
    }
    public void setLoanAccountId(long loanAccountId) {
        this.loanAccountId = loanAccountId;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public long getGuarantedId() {
        return guarantedId;
   }
    public void setGuarantedId(long guarantedId) {
        this.guarantedId = guarantedId;
    }
   public String getLoanAccountNo() {
        return loanAccountNo;
    }
    public void setLoanAccountNo(String loanAccountNo) {
        this.loanAccountNo = loanAccountNo;
    }
    public char getLoanType() {
        return loanType;
    }
    public void setLoanType(char loanType) {
        this.loanType = loanType;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Date getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
    public long getGuarantorId() {
        return guarantorId;
    }
    public void setGuarantorId(long guarantorId) {
        this.guarantorId = guarantorId;
    }
    public Guarantor getGuarantor() {
        return guarantor;
    }
    public void setGuarantor(Guarantor guarantor) {
        this.guarantor = guarantor;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }*/
    
    
}
