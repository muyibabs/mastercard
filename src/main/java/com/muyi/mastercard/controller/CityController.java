package com.muyi.mastercard.controller;

import com.muyi.mastercard.service.CityService;
import com.muyi.mastercard.service.CityServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);
    CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/connected")
    public String checkConnection(@RequestParam(name = "origin") String city1,
                                  @RequestParam(name = "destination") String city2){


        String connected = cityService.connected(city1,city2);
        return connected;

    }
}
