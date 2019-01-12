package com.ttgsolutions.springdemo.hibernate;

import com.ttgsolutions.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

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

            // create a student object
            System.out.println("Creating a new student object...");
            //Student tempStudent = new Student("Paul", "Wall", "Paul@email.com");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@email.com");

            // start the transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

            // commit transaction
            session.getTransaction().commit();

            // find the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId() + "  " + tempStudent);

            // get a new session
            session = factory.getCurrentSession();
            session.beginTransaction();

            // retrieve by id

            // commit the transaction
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get Complete: " + myStudent);

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
