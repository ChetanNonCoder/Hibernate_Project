package com.jspider.hibernate.manytoone_mapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspider.hibernate.manytoone_mapping.dto.PlayerDTO;
import com.jspider.hibernate.manytoone_mapping.dto.TemaDTO;

public class PlayerTeamDTO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("manytoone");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnetion() {
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
			
		TemaDTO team1 = new TemaDTO();
		
	         team1.setID(1);
	         team1.setName("CSK");
	         team1.setCity("Chennai");
	         
	      manager.persist(team1);
	      
	   
	   TemaDTO team2 = new TemaDTO();
	   
	        team2.setID(2);
	        team2.setName("RCB");
	        team2.setCity("Banglore");
	        
	     manager.persist(team2);
	     
	   
	   TemaDTO team3 = new TemaDTO();
	   
	       team3.setID(3);
	       team3.setName("MI");
	       team3.setCity("Mumbai");
	     
	     manager.persist(team3);
	     
	   PlayerDTO player1 = new PlayerDTO();
	       
	      player1.setID(1);
	      player1.setName("Rohit Sharma");
	      player1.setRoll("Bt");
	      player1.setJersey_No("45");
	      player1.setAge(39);
	      player1.setTeam(team3);
	      
	    manager.persist(player1);

      PlayerDTO player2 = new PlayerDTO();
	       
		      player2.setID(2);
		      player2.setName("M S Dhoni");
		      player2.setRoll("Bt/Wk");
		      player2.setJersey_No("7");
		      player2.setAge(41);
		      player2.setTeam(team1);
		      
		    manager.persist(player2);
	   
     PlayerDTO player3 = new PlayerDTO();
		       
			      player3.setID(3);
			      player3.setName("Virat Kohli");
			      player3.setRoll("Bt");
			      player3.setJersey_No("34");
			      player3.setAge(18);
			      player3.setTeam(team2);
			      
			    manager.persist(player1);		    
	           transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnetion();
		}
	}
}
