package com.novamsc.training.hibernate.model;

import java.util.HashSet;
import java.util.Set;

public class Guarantor
{
    private long guarantorId;
    private int version;
    private String name;
    private String nric;
    private Set<LoanAccount> loanAccounts = new HashSet<LoanAccount>();

    public long getGuarantorId() {
        return guarantorId;
    }

    public void setGuarantorId(long guarantorId) {
        this.guarantorId = guarantorId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        this.nric = nric;
    }

    public Set<LoanAccount> getLoanAccounts() {
        return loanAccounts;
    }

    public void setLoanAccounts(Set<LoanAccount> loanAccounts) {
        this.loanAccounts = loanAccounts;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((nric == null) ? 0 : nric.hashCode());
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
        Guarantor other = (Guarantor) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (nric == null) {
            if (other.nric != null)
                return false;
        } else if (!nric.equals(other.nric))
            return false;
        return true;
    }

    public void addLoanAccount(LoanAccount loanAccount) {
        if (loanAccount == null) {
            throw new IllegalArgumentException("Loan Account to be added mus not be null");
        }
        loanAccounts.add(loanAccount);
        loanAccount.setGuarantor(this);
    }

    /*
     * public long getGuarantorId() { return guarantorId; }
     * 
     * public void setGuarantorId(long guarantorId) { this.guarantorId = guarantorId; }
     * 
     * public int getVersion() { return version; }
     * 
     * public void setVersion(int version) { this.version = version; }
     * 
     * public String getName() { return name; }
     * 
     * public void setName(String name) { this.name = name; }
     * 
     * public String getNric() { return nric; }
     * 
     * public void setNric(String nric) { this.nric = nric; }
     * 
     * public Set<LoanAccount> getLoanAccounts() { return loanAccounts; }
     * 
     * public void setLoanAccounts(Set<LoanAccount> loanAccounts) { this.loanAccounts = loanAccounts; }
     * 
     * public void addLoanAccount(LoanAccount loanAccount) { if (loanAccount == null) { throw new
     * IllegalArgumentException("Attachment to be added must not be null!"); } loanAccount.setGuarantor(this);
     * loanAccounts.add(loanAccount); }
     * 
     */
}
