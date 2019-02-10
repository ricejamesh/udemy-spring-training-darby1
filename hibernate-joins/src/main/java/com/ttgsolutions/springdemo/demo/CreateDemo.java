package com.ttgsolutions.springdemo.demo;

import com.ttgsolutions.springdemo.entity.Instructor;
import com.ttgsolutions.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java object
        try {

            Instructor tempInstructor = new Instructor("Jim", "Rice", "james.rice@ttg-solutions.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.ttg-solutions.com", "Luv 2 code!!!");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start the transaction
            session.beginTransaction();


            // save the instructor.
            //
            // Note: this will also save any associated objects
            // due to CascadeType.ALL
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
