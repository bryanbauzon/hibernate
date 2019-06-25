package com.novamsc.training.hibernate.dao;

import java.util.List;

import com.novamsc.training.hibernate.dao.hibernate.AccountDAOImpl;
import com.novamsc.training.hibernate.model.Account;
import com.novamsc.training.hibernate.model.Address;
import com.novamsc.training.hibernate.model.Customer;
import com.novamsc.training.hibernate.util.AccountType;

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
public class AccountDAOTest
{
    private static GenericApplicationContext context;
        
    public AccountDAOTest() {
    }

    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
//    private AccountDAOImpl accountDaoImpl;
        
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
        // Exercise: Create the entity
 
        // Exercise: Delete the created entity
    }
    @Test
    public void findAccountByTypeBalance() {
        List<Account> accounts = (List<Account>) accountDAO.findAccountsByLastName_DC(AccountType.CHECKING);
        
        if(accounts != null) {
            System.out.println("SIZE: " + accounts.size());
            for(Account account:accounts) {
                System.out.println(account.getBalance());
            }
        }else {
            System.out.println("No Records Found");
        }
       
    }
    @Test
    public void testGet() {
        //Exercise: Get the entity from DB
    }
    
    @Test
    public void testRetrievelAll(){
        /*
         * Author: Caroline
         * NOTE: Do not modify this method. This is a quick workaround to test the hibernate mapping with DB table
         *
         *
         *
         */
//        List<Account> allAccounts = accountDAO.findAll();
//        System.out.println("all accounts size = " + allAccounts.size());
    }
}