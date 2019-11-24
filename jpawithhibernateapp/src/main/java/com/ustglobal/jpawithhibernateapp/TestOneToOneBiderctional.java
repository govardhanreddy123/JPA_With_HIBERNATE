package com.ustglobal.jpawithhibernateapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.onetoone.Person;
import com.ustglobal.jpawithhibernateapp.onetoone.VoterCard;

public class TestOneToOneBiderctional {
	public static void main(String[] args) {
		
		  VoterCard vc = new VoterCard();
		     vc.setVid(10);
		     vc.setVname("Ram");
		     
		     Person p = new Person();
		     p.setPid(01);
		     p.setPname("Ram");
		     p.setVotercard(vc);

			EntityManager entityManager = null;
			EntityTransaction entityTransaction = null;
			try {
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
				entityManager = entityManagerFactory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				VoterCard voter = entityManager.find(VoterCard.class, 10);
				System.out.println(voter.getPerson().getPid());
				System.out.println(voter.getPerson().getPname());
				//entityManager.persist(p);
			   Person p1 =  entityManager.find(Person.class, 1);
			   System.out.println(p.getVotercard().getVname());
				System.out.println("Record Saved");
				entityTransaction.commit();

			}catch(Exception e) {
				e.printStackTrace();
				entityTransaction.rollback();
			}
			
			entityManager.close();

	}

}
