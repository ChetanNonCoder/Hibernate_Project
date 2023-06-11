package com.jspider.hibernate.manytomany.manytomanyBidirectional.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Table;

import com.jspider.hibernate.manytomany.manytomanyBidirectional.dto.StudentDTO;
import com.jspider.hibernate.manytomany.manytomanyBidirectional.dto.SubjectDTO;

@Table(name = "std_sub")
public class SubjectsStudentDAO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("manytomany");
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
			
			
			StudentDTO  std1 = new StudentDTO();
//			std1.setId(1);
			std1.setName("chetan");
			std1.setAddress("pune");
			
			StudentDTO  std2 = new StudentDTO();
//			std2.setId(2);
			std2.setName("chiku");
			std2.setAddress("pune");
			
			StudentDTO  std3 = new StudentDTO();
//			std3.setId(3);
			std3.setName("chets");
			std3.setAddress("pune");
			
		     List<StudentDTO> STD =  Arrays.asList(std1,std2,std3);
			SubjectDTO sub1 = new SubjectDTO();
		    sub1.setId(1);
		    sub1.setName("coreJava");
		    sub1.setDuration(3);
		    sub1.setStudents(STD);
		    
		    SubjectDTO sub2 = new SubjectDTO();
		    sub2.setId(2);
		    sub2.setName("coreJava");
		    sub2.setDuration(3);
		    sub2.setStudents(STD);
		    
		    List<SubjectDTO> SUB = Arrays.asList(sub1,sub2);
		    
		    std1.setSubjects(SUB);
		    manager.persist(std1);
		    
		    std2.setSubjects(SUB);
		    manager.persist(std2);
		    
		    std3.setSubjects(SUB);
		    manager.persist(std3);
		    
		    
		    transaction.commit();
		    
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}
