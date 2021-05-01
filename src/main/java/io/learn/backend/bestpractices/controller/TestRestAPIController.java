package io.learn.backend.bestpractices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.learn.backend.bestpractices.bean.TestRestAPI;
import io.learn.backend.bestpractices.service.TestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TestRestAPIController {

    @Autowired
    private TestService ts;

    @Autowired
    private TestRestAPI component;

    private static final Logger logger = LoggerFactory.getLogger(TestRestAPIController.class);

    @GetMapping(value = {"/weather", "/weather/{city}"})
    public TestRestAPI getWeatherData(@PathVariable(required = false) String city) {

        logger.info("City : " + city);
        if (city == null || city.trim().length() == 0) {
            return component;
        } else {
            return ts.getTemperature(city);
        }

    }
}
