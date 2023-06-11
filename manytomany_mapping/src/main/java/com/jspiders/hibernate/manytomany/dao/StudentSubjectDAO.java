package com.jspiders.hibernate.manytomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.manytomany.dto.StudentDTO;
import com.jspiders.hibernate.manytomany.dto.SubjectDTO;

public class StudentSubjectDAO {

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
		
		try{
			openConnection();
			transaction.begin();
			
	SubjectDTO sub1 = new SubjectDTO();
	
//	    sub1.setId(1);
	    sub1.setName("CoreJava");
	    sub1.setDuration(3);
	    manager.persist(sub1);
	    
	SubjectDTO sub2 = new SubjectDTO();
	
//	   sub2.setId(2);
	   sub2.setName("J2EE");
	   sub2.setDuration(3);
	   manager.persist(sub2);
	   
	SubjectDTO sub3 = new SubjectDTO();
	
//	   sub3.setId(3);
	   sub3.setName("SQL");
	   sub3.setDuration(3);
	   manager.persist(sub3);
	   
    List<SubjectDTO> subjects = Arrays.asList(sub1,sub2,sub3);
    
    StudentDTO Student1 = new StudentDTO();
      
//        Student1.setId(1);
        Student1.setName("Chetan Jadhav");
        Student1.setEmail("chetanjadhav@gmail.com");
        Student1.setAddress("Pune");
        Student1.setSubject(subjects);
        manager.persist(Student1);
        
        StudentDTO Student2 = new StudentDTO();
        
//        Student2.setId(2);
        Student2.setName("Darshan Patil");
        Student2.setEmail("darshan@gmail.com");
        Student2.setAddress("Pune");
        Student2.setSubject(subjects);
        manager.persist(Student2);
        
        StudentDTO Student3 = new StudentDTO();
        
//        Student3.setId(3);
        Student3.setName("PavanKumar Yadav");
        Student3.setEmail("pavankumar@gmail.com");
        Student3.setAddress("Pune");
        Student3.setSubject(subjects);
        manager.persist(Student3);
        
        transaction.commit();
		}finally {
			closeConnection();
		}
	}
}
