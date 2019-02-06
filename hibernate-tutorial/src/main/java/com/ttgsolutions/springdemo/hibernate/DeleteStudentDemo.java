package com.ttgsolutions.springdemo.hibernate;

import com.ttgsolutions.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();


        // use the session object to save Java object
        try {
            int studentId = 3;

            // Create session
            Session session = factory.getCurrentSession();

            // start the transaction
            session.beginTransaction();

            // retrieve student based on id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Get Complete: " + myStudent.toString());


            System.out.println("Deleting student.");

            session.delete(myStudent);

            int nextStudent = 3;

            System.out.println("Deleting student " + nextStudent);

            session.createQuery("delete from Student where id=2").executeUpdate();


            // commit transaction
            session.getTransaction().commit();



            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
