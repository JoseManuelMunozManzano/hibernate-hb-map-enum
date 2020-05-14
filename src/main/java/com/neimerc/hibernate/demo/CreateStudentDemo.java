package com.neimerc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neimerc.hibernate.demo.entity.Status;
import com.neimerc.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create object
			Student tempStudent = new Student("José Manuel", "Muñoz Manzano", "xxxx@b.com", Status.ACTIVE);
		
			// begin a transaction
			session.beginTransaction();
		
			// saves the object
			System.out.println("Saving the student...");
			session.persist(tempStudent);
		
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
