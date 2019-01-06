package com.ttgsolutions.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public FortuneService getFortuneService() {
        return fortuneService;
    }

//    @Autowired
//    public void setFortuneService(@Qualifier("randomFortuneService") FortuneService fortuneService) {
//        System.out.println(">> Autowire -- TennisCoach: -- inside setFortuneService\n");
//        this.fortuneService = fortuneService;
//    }

    @Autowired
    private SimpleClass simpleClass;


    public String getEmail() {
        return email;
    }

    public String getCoachName() {
        return coachName;
    }

    @Value("${tennis.email}")
    private String email;

    @Value("${tennis.coach}")
    private String coachName;


    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach: -- inside default constructor");
    }

    public String doSomething() {
        return simpleClass.doSomething();
    }


//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }
    
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
