package com.ddh.learn.work2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestWork2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestWork2Application.class, args);
    }

    @GetMapping("test-work2")
    public String test() {
        return "test-work2";
    }
}
