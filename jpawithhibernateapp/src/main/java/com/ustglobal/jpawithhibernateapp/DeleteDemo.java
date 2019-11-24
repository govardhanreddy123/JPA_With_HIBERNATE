package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class DeleteDemo {
	public static void main(String[] args) {

		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			ProductInfo productInfo=entityManager.find(ProductInfo.class, 101);
			entityManager.remove(productInfo);
			System.out.println("Deleted Record");
			entityTransaction.commit();
			entityManager.close();

		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}

		entityManager.close();
	}
}
