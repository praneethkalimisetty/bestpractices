package io.learn.backend.bestpractices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String testRequest(){
        return "Test is successful !!!";
    }

    @PostMapping(value = "/test/{param}")
    public String testPostRequestWithPathVariable(@PathVariable String param){
        return "Test is successful for pathvariable : " + param;
    }

    @PostMapping(value = "/test")
    public String testPostRequestWithRequestParam(@RequestParam String param){
        return "Test is successful for RequestParam : " + param;
    }
}
