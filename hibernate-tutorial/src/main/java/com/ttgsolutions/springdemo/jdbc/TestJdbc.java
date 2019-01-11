package com.ttgsolutions.springdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {



        String jdbcUrl = "jdbc:postgresql://localhost/hb_student_tracker?ssl=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {

            System.out.println("Connecting to database: " + jdbcUrl);

            Connection connection =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}
