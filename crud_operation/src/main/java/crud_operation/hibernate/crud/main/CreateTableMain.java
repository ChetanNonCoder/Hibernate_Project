package crud_operation.hibernate.crud.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import crud_operation.hibernate.crudo.CreateTable;

public class CreateTableMain {

	private static EntityManagerFactory factory ;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnetion() {
		factory = Persistence.createEntityManagerFactory("crud");
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
			openConnetion();
			transaction.begin();
			
			CreateTable create = new CreateTable();
			
//			create.setId(1);
			create.setName("jjjjj");
			create.setEmail("22222000");
			create.setDob("2222200");
			create.setPhone_No(123456789);
			manager.persist(create);
			
			CreateTable create2 = new CreateTable();
			 
//			create.setId(2);
			create.setName("kkkk");
			create.setEmail("yyyyyy");
			create.setDob("21313232");
			create.setPhone_No(121212121212L);
			manager.persist(create2);
			
			transaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeConnetion();
		}
		
	}
}
