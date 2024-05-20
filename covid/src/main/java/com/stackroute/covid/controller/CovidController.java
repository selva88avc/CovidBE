package com.stackroute.covid.controller;

import com.stackroute.covid.modal.CovidStateAnalytics;
import com.stackroute.covid.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/covid")
public class CovidController {
    @Autowired
    CovidService covidService;

    @GetMapping(value = "/view")
    public ResponseEntity<List<?>> getAllProducts() {
        List<CovidStateAnalytics> covidData = covidService.getAllCovidInputs();
        return new ResponseEntity<>(covidData, HttpStatus.OK);
    }
}