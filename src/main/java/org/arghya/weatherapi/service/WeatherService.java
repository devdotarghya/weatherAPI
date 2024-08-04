package org.arghya.weatherapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private RestClient restClient;

    public WeatherService(RestClient restClient){
        this.restClient = restClient;
    }

    public ResponseEntity<String> getWeatherByCity(String city, String appId) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                .path("/")
                .queryParam("q", city)
                .queryParam("appid", appId)
                        .build())
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .toEntity(String.class);

    }
}
