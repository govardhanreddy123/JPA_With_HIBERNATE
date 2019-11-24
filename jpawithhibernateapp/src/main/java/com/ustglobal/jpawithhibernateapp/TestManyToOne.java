package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.dto.ProductInfo;
import com.ustglobal.jpawithhibernateapp.onetomany.Pencil;
import com.ustglobal.jpawithhibernateapp.onetomany.PencilBox;

public class TestManyToOne {
	
	public static void main(String[] args) {
		
		PencilBox pb = new PencilBox();
		pb.setBid(1);
		pb.setBname("Apsara");
		
		Pencil p1 = new Pencil();
		p1.setId(11);
		p1.setColor("red");
		p1.setPencilBox(pb);
		
		Pencil p2 = new Pencil();
		p2.setId(12);
		p2.setColor("black");
		p2.setPencilBox(pb);
		
		

		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
//			entityManager.persist(p1);
//			entityManager.persist(p2);
			 PencilBox pb1 = entityManager.find(PencilBox.class, 1);
			 System.out.println(pb1.getPencil().get(0));
			System.out.println("Record Saved");
			entityTransaction.commit();
			entityManager.close();

		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		
		entityManager.close();
		
	}

}
