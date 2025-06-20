package org.example.demo0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo0Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo0Application.class, args);
    }
    @RequestMapping("/")
    public String index() {
        return "The / page";
    }

}
