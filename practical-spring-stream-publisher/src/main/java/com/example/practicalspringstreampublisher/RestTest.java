package com.example.practicalspringstreampublisher;

import com.example.practicalspringstreampublisher.event.source.SimpleSourceBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {

    private final SimpleSourceBean simpleSourceBean;

    public RestTest(SimpleSourceBean simpleSourceBean) {
        this.simpleSourceBean = simpleSourceBean;
    }

    @GetMapping("/helloWorld")
    public String sayHello(@RequestParam(name = "name") String name){

        simpleSourceBean.publishChange("sayHello", name);

        return "Hello "+name;
    }
}
