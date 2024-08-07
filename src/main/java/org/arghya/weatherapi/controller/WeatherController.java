package org.arghya.weatherapi.controller;

import org.arghya.weatherapi.model.Weather;
import org.arghya.weatherapi.service.WeatherService;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    public  WeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<Weather> getWeatherByCity(@RequestParam(name = "city") String city,
                                                    @RequestParam(name = "appId") String appId){
        return ResponseEntity.ok(weatherService.getWeatherByCity(city, appId));
    }
}
