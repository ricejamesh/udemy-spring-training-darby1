package com.ttgsolutions.springdemo.demo;

import com.ttgsolutions.springdemo.entity.Course;
import com.ttgsolutions.springdemo.entity.Instructor;
import com.ttgsolutions.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalCourseCreateDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java object
        try {

            // start the transaction
            session.beginTransaction();


            Instructor tempInstructor = new Instructor("John", "Smith", "John.Smith@email.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("www.twitter.com", "Keeping it real!");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            Course tempCourse1 = new Course("Physics 101", tempInstructor);

            Course tempCourse2 = new Course("Chemistry 101", tempInstructor);

            System.out.println("Saving instructor: " + tempInstructor);

            session.save(tempInstructor);
            session.save(tempCourse1);
            session.save(tempCourse2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
