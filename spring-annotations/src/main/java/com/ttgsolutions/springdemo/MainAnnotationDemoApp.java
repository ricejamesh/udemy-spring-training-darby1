package com.ttgsolutions.springdemo;

import com.ttgsolutions.springdemo.utils.MyLoggerConfig;
import com.ttgsolutions.springdemo.utils.ResourceFileLoader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotationDemoApp {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLoggerConfig.class, SportConfig.class);

        Coach myCoach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println("------------\n");

        System.out.println(myCoach.getDailyWorkout() + "\n");

        System.out.println(myCoach.getDailyFortune() + "\n");

//        System.out.println(((TennisCoach) myCoach).doSomething() + "\n");
//
        System.out.println(((SwimCoach) myCoach).getEmail() + "\n");

        System.out.println("------------");

        context.close();

    }
}
