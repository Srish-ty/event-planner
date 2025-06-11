package org.example.demo0.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }
    @GetMapping("next")
    public String index() {
        return "Hello to /api/next endpoint";
    }
}
