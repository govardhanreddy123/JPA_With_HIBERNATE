package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class ReadDemo {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ProductInfo productDetail  =entityManager.find(ProductInfo.class, 101);
		System.out.println("ID is :"+productDetail.getPid());
		System.out.println("Name is :"+productDetail.getPname());
		System.out.println("Quantity is :"+productDetail.getQuantity());
		entityManager.close();


	}

}
