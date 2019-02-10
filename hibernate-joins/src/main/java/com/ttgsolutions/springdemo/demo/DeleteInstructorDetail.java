package com.ttgsolutions.springdemo.demo;

import com.ttgsolutions.springdemo.entity.Instructor;
import com.ttgsolutions.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {

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

            // start the transaction
            session.beginTransaction();


            int instructorDetailID = 7;

            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, instructorDetailID);

            System.out.println("Retrieved InstructorDetail = " + tempInstructorDetail);

            System.out.println("Instructor: " + tempInstructorDetail.getInstructor());


            System.out.println("Deleting tempInstructorDetail " + tempInstructorDetail);

            // remove associated object reference. Break bi-directional link.
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            // Delete instructor detail
            session.delete(tempInstructorDetail);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
