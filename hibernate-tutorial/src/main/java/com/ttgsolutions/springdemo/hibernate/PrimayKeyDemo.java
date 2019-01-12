package com.ttgsolutions.springdemo.hibernate;

import com.ttgsolutions.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimayKeyDemo {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java object
        try {

            // create 3 student objects
            System.out.println("Creating a new student object...");
            //Student tempStudent = new Student("Paul", "Wall", "Paul@email.com");
            Student tempStudent1 = new Student("John", "Lennon", "John@email.com");
            Student tempStudent2 = new Student("Paul", "McCartney", "Paul@email.com");
            Student tempStudent3 = new Student("Paul", "Wall", "Wall@email.com");

            // start the transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
