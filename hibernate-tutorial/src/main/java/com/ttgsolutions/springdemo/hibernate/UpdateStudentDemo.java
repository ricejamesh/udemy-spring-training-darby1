package com.ttgsolutions.springdemo.hibernate;

import com.ttgsolutions.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

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

            int studentId = 1;

            // start the transaction
            session.beginTransaction();

            // retrieve student based on id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Get Complete: " + myStudent.toString());
            System.out.println("Updating...");

            myStudent.setFirstName(myStudent.getFirstName() + "+");

            // commit transaction
            session.getTransaction().commit();

            // ------------------

            // start the transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Update email for all students

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            // commit transaction
            session.getTransaction().commit();



            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
