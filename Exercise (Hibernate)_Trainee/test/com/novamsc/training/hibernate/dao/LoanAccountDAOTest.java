package com.novamsc.training.hibernate.dao;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

import com.novamsc.training.hibernate.model.Account;
import com.novamsc.training.hibernate.model.Customer;
import com.novamsc.training.hibernate.model.LoanAccount;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 *
 * @author yewfai.chan
 */
public class LoanAccountDAOTest
{
    private static GenericApplicationContext context;
        
    public LoanAccountDAOTest() {
    }

    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
    private LoanAccountDAO loanAccountDAO;
    
    public void setLoanAccountDAO(LoanAccountDAO loanAccountDAO) {
        this.loanAccountDAO = loanAccountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }    
    
    private static String[] getConfigLocations() {
        return new String[]{
                "classpath*:/applicationContext-resources.xml",
                "classpath*:/applicationContext-dao.xml",
            };
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        // setup spring context        
        context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions(getConfigLocations());
        context.refresh();
        context.registerShutdownHook();
    }

    @Before
    public void setUp() {
        System.out.println("setUp called!!!!!!!");
        // inject dependency
        context.getBeanFactory().autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true);                
    }
    
    
    /**
     * Below are the unit test functions
     */
    @Test
    public void testCreate() {
        
        
    }

    @Test
    public void testGet() {
        
    }
    
    @Test
    public void testRetrievelAll(){
        /*
         * Author: Caroline
         * NOTE: Do not modify this method. This is a quick workaround to test the hibernate mapping with DB table
         */
        List<LoanAccount> allLoanAccounts = loanAccountDAO.findAll();
        System.out.println("all loan accounts size = " + allLoanAccounts.size());
    }
}