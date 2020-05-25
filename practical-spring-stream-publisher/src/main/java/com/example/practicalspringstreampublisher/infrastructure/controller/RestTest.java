package com.example.practicalspringstreampublisher.infrastructure.controller;

import com.example.practicalspringstreampublisher.application.ExampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RestTest {

    private final ExampleService exampleService;

    public RestTest(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/helloWorld")
    public String sayHello(@RequestParam(name = "name") String name){

      return  exampleService.sayHello(name, UUID.randomUUID().toString());

    }
}
