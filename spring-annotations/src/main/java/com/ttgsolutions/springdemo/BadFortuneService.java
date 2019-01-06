package com.ttgsolutions.springdemo;

public class BadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "No good things are in your future...";
    }
}
