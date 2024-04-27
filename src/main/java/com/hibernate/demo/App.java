package com.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.github.javafaker.Faker;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = null;
        Session s = null;
        Transaction tx = null;
        
        Session s1 = null;
        Transaction tx1 = null;

        
        try {
        	sf = new Configuration().configure().buildSessionFactory();
        	s  = sf.openSession();
        	tx = s.beginTransaction();
        	
        	s1  = sf.openSession();
        	tx1 = s1.beginTransaction();
        	
      /*  	List<Customer> customers = generateFakeCustomers(5000);
        	
        	for(Customer c : customers) {
        		s.save(c);
        	}
        	*/
        	
        	Customer c = s.get(Customer.class, 2L);
        	
        	System.out.println(c);
        	
        	
            Customer c1 = s1.get(Customer.class, 2L);
        	
        	System.out.println(c1);
        	
        }
        catch(HibernateException e) {
        	if(tx != null)
        		tx.rollback();
        	if(tx1 != null)
        		tx1.rollback();
        	e.printStackTrace();
        }
        catch(Exception e) {
        	if(tx != null)
        		tx.rollback();
        	if(tx1 != null)
        		tx1.rollback();
        	e.printStackTrace();
        }
        finally {
        	if(tx != null)
        		tx.commit();
        	if(tx1 != null)
        		tx1.commit();
        	if(s != null)
        		s.close();
        	if(s1 != null)
        		s1.close();
        	if(sf != null)
        		sf.close();
		}
    }
    
    private static List<Customer> generateFakeCustomers(int numberOfCustomers){
    	Faker f = new Faker();
    	java.util.List<Customer> customers = new ArrayList<Customer>();
    	
    	for(int i = 0 ; i <= numberOfCustomers ; i++) {
    		long id = i;
    		String  name = f.name().fullName();
    		String address = f.address().fullAddress();
    		double creditLimit = f.number().randomDouble(2, 10000, 10000);
    		double billAmount = f.number().randomDouble(2, 500, 8000);
    		
    	
    		Customer customer = new Customer(id,name,address,creditLimit,billAmount);
            customers.add(customer);
    	}
    	
    	return customers;
    }
}
