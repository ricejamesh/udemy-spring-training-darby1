package com.ttgsolutions.springdemo;

import com.ttgsolutions.springdemo.utils.ResourceFileLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        int index = getIndex();
        if (index >= 0)
            return fortunes[index];
        else
            return "Your fortune will be better tomorrow...";
    }

    String[] fortunes;

    Random random = new Random();

    private Integer getIndex() {
        if (fortunes != null)
            return random.nextInt(fortunes.length);
        else
            return -1;
    }

    @PostConstruct
    void OnInit() {
        System.out.println(">> RandomFortuneService: Initializing RandomFortuneService");
        fortunes = ResourceFileLoader.getResource("fortunes.txt");
    }
}
