package org.rusgidro.controllers;

import lombok.RequiredArgsConstructor;
import org.rusgidro.Service.CityService;
import org.rusgidro.entity.City;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @GetMapping("/all")
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }
}
