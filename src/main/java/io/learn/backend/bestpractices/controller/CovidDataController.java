package io.learn.backend.bestpractices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.learn.backend.bestpractices.bean.Covid;
import io.learn.backend.bestpractices.service.CovidService;

@RestController
public class CovidDataController {

    @Value("${covid.api.host}")
    private String url;

    @Autowired
    private CovidService service;

    @GetMapping(value = "/covid")
    public String processCovidData() {
        return service.insertCovidData(url);
    }

    @GetMapping(value = "/covid/{statecode}")
    public Covid findStateData(@PathVariable String statecode) {
        Covid covid = service.getStateData(statecode);
        return covid;

    }
}
