package com.ustglobal.jpawithhibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicjpqlQuery {
	public static void main(String[] args) {

		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction =entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "update ProductInfo set pname=:name where pid =:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("name", "Book");
			query.setParameter("id", 102);
			int result = query.executeUpdate();
			System.out.println(result +"Record Updated");
			entityTransaction.commit();
		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();

		}finally {
			entityManager.close();
		}
	}


}
