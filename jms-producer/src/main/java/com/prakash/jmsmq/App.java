package com.prakash.jmsmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication(scanBasePackages = "com.prakash.jmsmq.controller")
public class App
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
