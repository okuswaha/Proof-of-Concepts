package com.prakash.jmsmq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {
    @RequestMapping("/validate")
    public String isEvenOrOdd() {
        return "Hello Spring Boot : ";
    }

    @RequestMapping("/")
    public String greetings() {
        return "Hello Spring Boot : ";
    }
}
