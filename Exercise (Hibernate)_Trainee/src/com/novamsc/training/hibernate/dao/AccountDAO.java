package com.novamsc.training.hibernate.dao;

import java.util.Collection;

import com.novacitynets.pavo.core.dao.GenericDAO;
import com.novamsc.training.hibernate.model.Account;
import com.novamsc.training.hibernate.util.AccountType;

/**
 * Interface for the Account DAO.<p>
 * 
 * @author yewfai.chan
 */
public interface AccountDAO extends GenericDAO<Account, Long>
{
        public Collection<Account> findAccountTypeByBalance(AccountType accountType);
        public Collection<Account> findAccountsByTypeBalanceHQL(AccountType accountType);
        public Collection<Account>  findAccountsByLastName_DC(AccountType accountType);
        public Collection<Account> findAccountsByLastName_HQL(AccountType accountType);
}
