package com.jspiders.hibernsteOnetoOne.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernsteOnetoOne.dto.AdharDTO;
import com.jspiders.hibernsteOnetoOne.dto.PersonDTO;

public class PersonAdharDTO {

	private static  EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection(){
		factory = Persistence.createEntityManagerFactory("onetoone");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		
     try {
    	openConnection();
    	transaction.begin();
    	
    	AdharDTO adhar1 = new AdharDTO();
    	
          adhar1.setId(1);
          adhar1.setDoi("01-04-2023");
          adhar1.setAdhar_no(858585858);
          manager.persist(adhar1);
          
       PersonDTO person1 = new PersonDTO();
         
          person1.setId(1);
          person1.setName("Chetan Jadhav");
          person1.setContact(858585854);
          person1.setDob("12-03-2001");
          person1.setAddress("pune");
          person1.setAadhar(adhar1);
         manager.persist(person1);
         
        transaction.commit(); 
     }finally {
		closeConnection();
	}
	}
}
