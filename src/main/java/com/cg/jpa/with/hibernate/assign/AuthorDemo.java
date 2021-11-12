package com.cg.jpa.with.hibernate.assign;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.jpa.with.hibernate.assign.entities.Author;

public interface AuthorDemo {
	
public static void main(String[] args) {
		
		System.out.println("Start");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abcd");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		
		tr.begin();
	
		// Inserting record  ---> After insertion we cannot again insert that record
		Author emp1 = new Author(101,"Suhasini","f","kollure",4568215);
		Author emp2 = new Author(102,"satvik","","shettar",768575);
		Author emp3 = new Author(103,"sonu",null,"monu",854321);
		em.persist(emp1);  //insert
		em.persist(emp2);
		em.persist(emp3);
		
//		em.remove(emp2);
		
		// Updating record
//		emp1.setFirstName("Akhilesh");
//		em.merge(emp1);    //Update
		
		// Displaying record
		Author aut = em.find(Author.class, 101);   //Select
		System.out.println(aut.toString());
		
		tr.commit();
		System.out.println("End");
}

}