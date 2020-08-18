package com.ddh.learn.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestWebApplication.class, args);
    }

    @GetMapping("test-web")
    public String test() {
        return "test-web";
    }
}
