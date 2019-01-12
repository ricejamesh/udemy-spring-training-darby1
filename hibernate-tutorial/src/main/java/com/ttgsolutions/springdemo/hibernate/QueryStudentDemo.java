package com.ttgsolutions.springdemo.hibernate;

import com.ttgsolutions.springdemo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

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
            // start the transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            // display the Students
            displayStudents(theStudents);

            System.out.println("\n\nStudents who have last name of Wall");
            theStudents = session.createQuery("from Student s where s.lastName = 'Wall'").getResultList();
            displayStudents(theStudents);


            // query students: lastname='Wall' OR firstName='Daffy'
            System.out.println("\n\nStudents who have last name of Wall or first name of Daffy");
            theStudents = session.createQuery("from Student s where s.lastName='Wall' OR s.firstName='Duck'").getResultList();
            displayStudents(theStudents);


            System.out.println("\n\nStudents who have email LIKE '%all%'");
            theStudents = session.createQuery("from Student s where s.email LIKE '%all%'").getResultList();
            displayStudents(theStudents);


            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        // display the students
        for (Student student: theStudents) {
            System.out.println(student);
        }
    }
}
