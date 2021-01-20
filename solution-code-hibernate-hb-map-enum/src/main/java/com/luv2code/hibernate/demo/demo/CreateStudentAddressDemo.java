package com.luv2code.hibernate.demo.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Address;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.addAnnotatedClass(Address.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the object
			Student tempStudent = new Student ("Paul", "Wall", "paul@luv2code.com");
			
			// create the address object
			Address billingAddress = new Address("Some Billing Street", "Some Billing City", "12345");
			
			// start a transaction
			session.beginTransaction();
			
			// save the object
			System.out.println("Saving the student and address...");
			tempStudent.setBillingAddress(billingAddress);
			session.save(tempStudent);
			
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
