package com.tech.hibernatedemo;

import java.util.Collections;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class StudentInsert {


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Student student = new  Student();

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try { 



			System.out.println("Enter the RollNo : ");
			int roll = scanner.nextInt();

			System.out.println("Enter the name : ");
			String name = scanner.next();

			System.out.println("Enter the phoneNo : ");
			long  phoneNo = scanner.nextLong();

			System.out.println("Enter the Section : ");
			String section = scanner.next();

			student.setRollNo(roll);
			student.setName(name);
			student.setPhoneNo(phoneNo);
			student.setSection(section);

			factory = Persistence.createEntityManagerFactory("emp"); 
			manager = factory.createEntityManager(); 
			transaction = manager.getTransaction(); 
			transaction.begin();


			manager.persist(student);
			transaction.commit();   

		}catch (Exception e) {
			e.printStackTrace();
			if(transaction != null) {
				transaction.rollback();
			}
		}finally {
			if(manager != null) {
				manager.close();
			}

			if(factory != null) {
				factory.close();
			}
		}

	}
}



