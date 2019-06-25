package com.novamsc.training.ioc;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * A class to test the Dependency Injection.<p>
 * 
 * @author yewfai.chan
 */
public class TestDI
{
    private static String[] getConfigLocations() {
        return new String[]{
                "classpath*:/applicationContext-ioc.xml",
            };
    }
    
    private Person person;
    

    public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	public String printStatement(){
	    String statement = person.getFirstName() + " " + person.getLastName() + " has SGD " + person.getWallet().getMoney() + "in his wallet.";
	    return statement;
	}



	public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions(getConfigLocations());
        context.refresh();
        context.registerShutdownHook();

        // in this situation we need to manually lookup the bean from the context file
        Person person = (Person)context.getBean("person");
        //System.out.println("Person = " + person);     
        System.out.println(person.getFirstName() + " " + person.getLastName() + " has SGD " + person.getWallet().getMoney() + "in his wallet.");
        
        /*TestDI testDI = new TestDI();
        String output = testDI.printStatement();
        System.out.println(output);*/
    }
}
