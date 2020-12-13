package com.izone.mailcrawling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MailCrawlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailCrawlingApplication.class, args);
    }

}
