package com.luv2code.hibernate.demo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Status;
import com.luv2code.hibernate.demo.entity.User;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(User.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the object
			User tempStudent1 = new User ("Paul", "Wall", "paul@luv2code.com", Status.ACTIVE);
			User tempStudent2 = new User ("Mary", "Public", "Mary@luv2code.com", Status.INACTIVE);
			
			// start a transaction
			session.beginTransaction();
			
			// save the object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			// clean up code
			session.close();
			factory.close();
		}

	}
}
