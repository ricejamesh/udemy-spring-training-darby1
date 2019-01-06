package com.ttgsolutions.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SimpleClass {
    public String doSomething() {
        return "I just did something!";
    }
}
