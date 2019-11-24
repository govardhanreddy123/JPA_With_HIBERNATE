package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class GetReference {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ProductInfo productInfo = entityManager.getReference(ProductInfo.class, 101);
		System.out.println("ID is :"+productInfo.getPid());
		System.out.println("Name is :"+productInfo.getPname());
		System.out.println("Quantity is :"+productInfo.getQuantity());
		entityManager.close();
	}

}
