package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class ReattachingDemo {

	public static void main(String[] args) {

		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			ProductInfo p  = entityManager.find(ProductInfo.class, 101);
			System.out.println(entityManager.contains(p));
			entityManager.detach(p);
			
			  ProductInfo p1 = entityManager.merge(p);
			  p1.setPname("laptop");
			System.out.println(entityManager.contains(p));
//			p.setPname("laptops");

			System.out.println("Record Updated");

			entityTransaction.commit();
		}catch(Exception e ) {
			e.printStackTrace();
			entityTransaction.rollback();
		}

		entityManager.close();

	}

}
