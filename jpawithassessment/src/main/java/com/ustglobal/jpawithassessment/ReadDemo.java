package com.ustglobal.jpawithassessment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ustglobal.jpawithassessment.dto.ProductInfo;

public class ReadDemo {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ProductInfo  p = entityManager.find(ProductInfo.class, 101);
		
		System.out.println("ID is: "+p.getPid());
		System.out.println("Name is :"+p.getPname());
		System.out.println("Quantity is :"+p.getQuantity());
		entityManager.close();
		
		
	}

}
