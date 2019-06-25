package com.novamsc.training.hibernate.dao.hibernate;

import java.util.Collection;

import com.novacitynets.pavo.core.dao.hibernate.AbstractGenericHibernateDAO;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.novamsc.training.hibernate.dao.AccountDAO;
import com.novamsc.training.hibernate.model.Account;
import com.novamsc.training.hibernate.util.AccountType;
import com.sun.tools.javac.util.List;

/**
 * A Hibernate implementation of a Account DAO.
 * <p>
 * 
 * @author yewfai.chan
 */
public class AccountDAOImpl extends AbstractGenericHibernateDAO<Account, Long> implements AccountDAO
{
    @Override
    public Collection<Account> findAccountTypeByBalance(AccountType accountTypes) {
        // TODO Auto-generated method stub
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Account.class);
        if (accountTypes == null) {
            detachedCriteria.add(Restrictions.isNull("accountType"));
        } else {
            detachedCriteria.add(Restrictions.eq("accountType", accountTypes));
        }
        detachedCriteria.add(Restrictions.ge("balance", new Double(2000)));// SELECT * FROM ACCOUNT WHERE balance >= 8000

        Collection<Account> accounts = getHibernateTemplate().findByCriteria(detachedCriteria);

        if (accounts.isEmpty()) {
            throw new IllegalArgumentException("No data found.");
        } else {
            return accounts;
        }
    }

    @Override
    public Collection<Account> findAccountsByTypeBalanceHQL(AccountType accountType) {

        Collection<Account> accounts = getHibernateTemplate().find("from Account a where a.balance >= 8000 AND a.accountType = ?",
                new Object[] { AccountType.CHECKING });

        if (accounts.isEmpty()) {
            return null;

        } else {
            return accounts;
        }

    }

    @Override
    public Collection<Account> findAccountsByLastName_DC(AccountType accountType) {

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Account.class);

        detachedCriteria.createAlias("customer", "c");

        detachedCriteria.add(Restrictions.ilike("c.lastName", "om", MatchMode.ANYWHERE));
        detachedCriteria.add(Restrictions.eq("accountType", accountType));
        detachedCriteria.addOrder(Order.asc("c.firstName"));
        // detachedCriteria.addOrder(Order.asc(propertyName))
        Collection<Account> accounts = getHibernateTemplate().findByCriteria(detachedCriteria);

        if (accounts.isEmpty()) {
            return null;
        } else {
            return accounts;
        }
    }

    @Override
    public Collection<Account> findAccountsByLastName_HQL(AccountType accountType) {
        // TODO Auto-generated method stub

        Collection<Account> accounts = getHibernateTemplate()
                .find("from Account t where type = ? and t.customer.lastName like '%om%' order by t.customer.firstName");

        if (accounts.isEmpty()) {
            return null;

        } else {
            return accounts;
        }
        //
    }

}
