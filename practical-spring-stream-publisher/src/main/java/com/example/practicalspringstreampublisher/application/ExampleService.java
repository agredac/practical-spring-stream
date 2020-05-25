package com.example.practicalspringstreampublisher.application;

import com.example.practicalspringstreampublisher.infrastructure.messagin.PublisherService;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    private final PublisherService publisherService;

    public ExampleService(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public String sayHello(String name, String id){

        publisherService.publishChange(name, id);

        return String.format("Hi %s with id %s", name, id);
    }
}
