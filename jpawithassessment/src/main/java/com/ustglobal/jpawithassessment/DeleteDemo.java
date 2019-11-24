package com.ustglobal.jpawithassessment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithassessment.dto.ProductInfo;

public class DeleteDemo {
	
	public static void main(String[] args) {
	
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		 
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			 ProductInfo p= entityManager.find(ProductInfo.class, 102);
			 entityManager.remove(p);
			System.out.println("Deleted Record");
			entityTransaction.commit();
			
		}catch(Exception e ) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}

}
