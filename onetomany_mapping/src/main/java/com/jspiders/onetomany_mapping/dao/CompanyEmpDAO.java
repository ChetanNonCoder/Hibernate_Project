package com.jspiders.onetomany_mapping.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomany_mapping.dto.Company;
import com.jspiders.onetomany_mapping.dto.Employee;

public class CompanyEmpDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("onetomany");
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
			
			Employee emp1 = new Employee();
			   
			  emp1.setId(1);
			  emp1.setName("Chetan jadhav");
			  emp1.setDesignation("Java Developer");
			  emp1.setSalary("100k");
			
			  manager.persist(emp1);

			  
		   Employee emp2 = new Employee();
		     
		      emp2.setId(2);
		      emp2.setName("PavanKumar Yadhav");
			  emp2.setDesignation("Team Leader");
			  emp2.setSalary("200k");
			 
			  manager.persist(emp2);
			  
	      Employee emp3 = new Employee();
			     
		      emp3.setId(3);
		      emp3.setName("Darshan Jadhav");
			  emp3.setDesignation("Manager");
			  emp3.setSalary("300k");
			 
			  manager.persist(emp3);
			  
		List<Employee> emp = Arrays.asList(emp1,emp2,emp3);
		
		Company com1 = new Company();
		  
		   com1.setId(1);
		   com1.setName("TCS");
		   com1.setDoe("10-05-1994");
		   com1.setAdd("Pune");
		   com1.setEmp(emp);
		   
		   manager.persist(com1);
			
		   
	    
//      Company com2 = new Company();
//			  
//		   com2.setId(2);
//		   com2.setName("Capgimini");
//		   com2.setDoe("01-12-1999");
//		   com2.setAdd("Pune");
//		   com2.setEmp(emp);
//		   
//		   manager.persist(com2);
//		   
//		   Company com3 = new Company();
//			  
//		   com3.setId(3);
//		   com3.setName("Infosys");
//		   com3.setDoe("11-02-2000");
//		   com3.setAdd("Pune");
//		   com3.setEmp(emp);
//		   
//		   manager.persist(com3);
		  transaction.commit();
		}finally {
			closeConnection();
		}
	}
	
}
