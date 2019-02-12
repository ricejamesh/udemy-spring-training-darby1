package com.ttgsolutions.springdemo.demo;

import com.ttgsolutions.springdemo.entity.Course;
import com.ttgsolutions.springdemo.entity.Instructor;
import com.ttgsolutions.springdemo.entity.InstructorDetail;
import com.ttgsolutions.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PopulateStudentsDemo {

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

            List<Student> students = new ArrayList<>();

            for (int i = 0; i < 300; i++) {
                String firstName = String.format("First-%d", i);
                String lastName = String.format("Last-%d", i);
                Student student = new Student(firstName, lastName, firstName + "." + lastName + "@email.com");
                students.add(student);
                session.save(student);
            }

            List<Course> theCourses = session.createQuery("from Course c").getResultList();

            Random random  = new Random();

            int min = 0;
            int max = students.size();




            for (Course course: theCourses) {
                for (int i = 0; i < 30; i++) {
                    int randomNum = ThreadLocalRandom.current().nextInt(min, max);
                }
            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
