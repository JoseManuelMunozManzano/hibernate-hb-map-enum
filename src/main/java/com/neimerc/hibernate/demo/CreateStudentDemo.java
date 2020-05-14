package com.neimerc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neimerc.hibernate.demo.entity.Status;
import com.neimerc.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create object
			Student tempStudent1 = new Student("José Manuel", "Muñoz Manzano", "xxxx@b.com", Status.ACTIVE);
			Student tempStudent2 = new Student("Maria", "Perez Lopez", "yyyy@b.com", Status.INACTIVE);
		
			// start a transaction
			session.beginTransaction();
		
			// save the object
			System.out.println("Saving the students...");
			session.persist(tempStudent1);
			session.persist(tempStudent2);
		
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {		
			// clean up code
			session.close();
			factory.close();
		}
	}

}
