package com.ustglobal.jpawithhibernateapp;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ustglobal.jpawithhibernateapp.manytomany.Courses;
import com.ustglobal.jpawithhibernateapp.manytomany.Student;
import com.ustglobal.jpawithhibernateapp.onetomany.Pencil;
import com.ustglobal.jpawithhibernateapp.onetomany.PencilBox;

public class TestManyTOMany {
	
	public static void main(String[] args) {
		
		Courses c = new Courses();
		c.setCid(10);
		c.setCname("pavan");
		Courses c1 = new Courses();
		c1.setCid(11);
		c1.setCname("guru");
		
		ArrayList<Courses> al = new ArrayList<Courses>();
		al.add(c);
		al.add(c1);
		
		Student s = new Student();
		s.setSid(1);
		s.setSname("Raju");
		s.setCourse(al);
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(s);
			System.out.println("Record Saved");
			entityTransaction.commit();
			

		}catch(Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		
		entityManager.close();
		
	}

}
