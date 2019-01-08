package com.ttgsolutions.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class HomeController {

    private Logger logger = Logger.getLogger("HomeController");

    @RequestMapping("/")
    public String showPage() {

        logger.info("--- logger.INFO message from HomeController. ---");
        System.out.println("--- System.out.println from HomeController.  ----");
        return "main-menu";
    }
}
