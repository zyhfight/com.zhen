package com.springboot.demo.controller;

import com.springboot.demo.domain.City;
import com.springboot.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zyh
 * @date : 2018-09-15 下午6:12
 */
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public City findCityByCityName(@RequestParam(value = "cityName", required = true) String cityName){
        System.out.println(cityName);
        City city = cityService.findCityByName(cityName);
        System.out.println(city);
        return city;
    }
}
