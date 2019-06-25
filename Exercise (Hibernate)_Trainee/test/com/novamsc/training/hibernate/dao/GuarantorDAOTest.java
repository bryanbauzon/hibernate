package com.novamsc.training.hibernate.dao;

//package com.novamsc.training.hibernate.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.novamsc.training.hibernate.model.Account;
import com.novamsc.training.hibernate.model.Address;
import com.novamsc.training.hibernate.model.Customer;
import com.novamsc.training.hibernate.model.Guarantor;
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
public class GuarantorDAOTest
{
    private static GenericApplicationContext context;

    public GuarantorDAOTest() {
    }

    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
    private LoanAccountDAO loanAccountDAO;
    private GuarantorDAO guarantorDAO;

    public void setLoanAccountDAO(LoanAccountDAO loanAccountDAO) {
        this.loanAccountDAO = loanAccountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void setGuarantorDAO(GuarantorDAO guarantorDAO) {
        this.guarantorDAO = guarantorDAO;
    }

    private static String[] getConfigLocations() {
        return new String[] { "classpath*:/applicationContext-resources.xml", "classpath*:/applicationContext-dao.xml", };
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
     * 
     * 
     */
    @Test
    public void testCreate() {
        
        Guarantor guarantor = new Guarantor();
        LoanAccount loanAccount1 = new LoanAccount();
        LoanAccount loanAccount2 = new LoanAccount();
        //adding guarantor
        guarantor.setName("guarantor 1");
        guarantor.setNric("test1");
        
        Customer customer = customerDAO.findById(new Long(701), true);
        
        loanAccount1.setAmount(2000);
        loanAccount1.setCustomer(customer);
        loanAccount1.setLoanAccountNo("1-22-333");
        loanAccount1.setLoanType('s');
        
        loanAccount2.setAmount(6000);
        loanAccount2.setCustomer(customer);
        loanAccount2.setLoanAccountNo("1200-22-333");
        loanAccount2.setLoanType('s');
        
        guarantor.addLoanAccount(loanAccount1);
        guarantor.addLoanAccount(loanAccount2);
        
        guarantorDAO.create(guarantor);
    }

    @Test
    public void testGet() {

    }

    @Test
    public void testRetrievelAll() {
        /*
         * Author: Caroline NOTE: Do not modify this method. This is a quick workaround to test the hibernate mapping with DB
         * table
         */
        List<Guarantor> allGuarantors = guarantorDAO.findAll();
        System.out.println("all guarantors size = " + allGuarantors.size());
    }
}
