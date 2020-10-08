package com.muyi.mastercard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
public class CityServiceImpl implements CityService {

    private static final String FILENAME = "city.txt";
    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Override
    public String connected(String city1, String city2) {
        List<String[]> cities = readCities();
        //loop through the cities and check city1 and city2
        for(String[] pair: cities){
            if((pair[0].equals(city1) && pair[1].equals(city2)) ||
                    (pair[0].equals(city2) && pair[1].equals(city1)))
                return "yes";
        }
        return "no";
    }

    //Method tp read city pairs from file into a List
    private List<String[]> readCities(){
        List<String[]> cities = new ArrayList<String[]>();
        try (Scanner scanner = new Scanner(new File(FILENAME))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] pair = line.split(",");
                pair[1] = pair[1].trim(); //remove leading spaces
                cities.add(pair);
            }
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        return cities;
    }
}
