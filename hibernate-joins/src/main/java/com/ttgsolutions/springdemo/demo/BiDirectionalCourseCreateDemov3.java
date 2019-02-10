package com.ttgsolutions.springdemo.demo;

import com.ttgsolutions.springdemo.entity.Course;
import com.ttgsolutions.springdemo.entity.Instructor;
import com.ttgsolutions.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalCourseCreateDemov3 {

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

            int theId = 4;

            Instructor tempInstructor = session.get(Instructor.class, theId);

//            InstructorDetail tempInstructorDetail = new InstructorDetail("www.twitter.com", "Running for the win!");
//
//            tempInstructor.setInstructorDetail(tempInstructorDetail);

            Course tempCourse1 = new Course();
            tempCourse1.setTitle("History 101");

            Course tempCourse2 = new Course();
            tempCourse2.setTitle("Civics 101");

            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            System.out.println("Saving tempcourse 1");
            session.save(tempCourse1);

            System.out.println("Saving tempcourse 2");
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
