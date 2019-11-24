package com.ustglobal.jpawithassessment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithassessment.dto.ProductInfo;

public class InsertDemo {
	
	public static void main(String[] args) {
		
		ProductInfo p = new  ProductInfo();
		p.setPid(102);
		p.setPname("books");
		p.setQuantity(20);
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		
		
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(p);
			System.out.println("Record Saved");
			
			entityTransaction.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		
		entityManager.close();
	}

}
