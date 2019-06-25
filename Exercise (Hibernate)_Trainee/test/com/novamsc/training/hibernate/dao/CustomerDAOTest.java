package com.novamsc.training.hibernate.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import com.novamsc.training.hibernate.model.Account;
import com.novamsc.training.hibernate.model.Address;
import com.novamsc.training.hibernate.model.Customer;
import com.novamsc.training.hibernate.model.Guarantor;
import com.novamsc.training.hibernate.util.AccountType;

/**
 *
 * @author yewfai.chan
 */
public class CustomerDAOTest
{
    private static GenericApplicationContext context;

    public CustomerDAOTest() {
    }

    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
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
     */
//    @Test
    public void testCreate() {
        // Exercise: Create the entity
      Customer customer = new Customer();
//        Guarantor guarantor = new Guarantor();
        
        Address address = new Address();
        Account account = new Account();
 

        customer.setLastName("Calisaan");
        customer.setFirstName("Camille");

        address.setAddress1("Anda");
        address.setAddress2(null);
        address.setCity("Alaminos");
        address.setState("455");
        address.setZip("2405");
        address.setCountry("Philippines");
        account.setBalance(new Double(1900));
        account.setAccountType(AccountType.CHECKING);
//701
        customer.addAccount(account);
        
        
        
//        2
        //

        customer.setAddress(address);
        customerDAO.create(customer);
//        
//        
//        

        // Exercise: Delete the created entity
    }

    @Test
    public void testGet() {
        // Exercise: Get the entity from DB

    }

//    @Test
    public void testRetrieveAll() {
        /*
         * Author: Caroline NOTE: Do not modify this method. This is a quick workaround to test the hibernate mapping with DB
         * table
         * 
         * 
         */

        // String query = "SELECT FIRSTNAME,LASTNAME,ADDRESS1 FROM training.CUSTOMER";
        List<Customer> allCustomers = customerDAO.findAll();
        // List<Account> allAccounts = customerDAO.findAll();

        // System.out.println("all customers size = " + allCustomers.get(0).toString());
        System.out.println("FIRSTNAME          |LASTNAME          |ADDRESS          |BALANCE          |ACCOUNT TYPE     ");
        for (Customer customer : allCustomers) {
            System.out.print(customer.getFirstName() + "          |" + customer.getLastName() + "          |" + customer.getAddress().printAddress()
                    + "          |");
            for (Account account : customer.getAccounts()) {
                System.out.println(account.getBalance() + "          |" + account.getAccountType());
            }
        }

        // for(int x = 0; x < allCustomers.size();x++) {
        // System.out.println(allCustomers.get(x).getFirstName().toString()+ " |
        // "+allCustomers.get(x).getLastName().toString()+" | ");
        // }

    }
}