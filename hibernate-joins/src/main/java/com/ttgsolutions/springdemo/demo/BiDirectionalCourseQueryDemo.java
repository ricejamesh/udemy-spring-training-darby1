package com.ttgsolutions.springdemo.demo;

import com.ttgsolutions.springdemo.entity.Course;
import com.ttgsolutions.springdemo.entity.Instructor;
import com.ttgsolutions.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class BiDirectionalCourseQueryDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
//                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        // use the session object to save Java object
        try {

            // start the transaction
            session.beginTransaction();


            List<Course> theCourses = session.createQuery("from Course c where c.title like '%101%' and c.instructor.firstName = 'Jim'").getResultList();

            displayCourses(theCourses);


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }

    private static void displayCourses(List<Course> theCourses) {
        // display the students
        for (Course course: theCourses) {
            System.out.println(course);
        }
    }
}
