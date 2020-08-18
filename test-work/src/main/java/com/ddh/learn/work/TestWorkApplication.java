package com.ddh.learn.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestWorkApplication.class, args);
    }

    @GetMapping("test-work")
    public String test() {
        return "test-work";
    }
}
