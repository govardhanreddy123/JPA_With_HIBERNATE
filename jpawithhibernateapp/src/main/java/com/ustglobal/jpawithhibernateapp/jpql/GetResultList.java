package com.ustglobal.jpawithhibernateapp.jpql;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;

public class GetResultList {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		String jpql = "from ProductInfo";
//		Query query = entityManager.createQuery(jpql);
//		 List<ProductInfo> l = query.getResultList();
//		 
//		 for(ProductInfo p : l) {
//			 System.out.println(p.getPid());
//			 System.out.println(p.getPname());
//			 System.out.println(p.getQuantity());
//			 
//		 }
		 
		String jpql = "select pname from ProductInfo";
		 Query query = entityManager.createQuery(jpql);
		 
		 List<String> ls = query.getResultList();
		 
		 for(String p : ls) {
    	 System.out.println(p);
    	 System.out.println("==============");
		 }
		 
		 
		 
		entityManager.close();
		
	}
	

}
