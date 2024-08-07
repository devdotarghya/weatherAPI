package org.arghya.weatherapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.arghya.weatherapi.model.Weather;
import org.arghya.weatherapi.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class WeatherService {

    private RestClient restClient;

    private ObjectMapper objectMapper;

    private WeatherRepository weatherRepository;

    public WeatherService(RestClient restClient, ObjectMapper objectMapper, WeatherRepository weatherRepository){
        this.restClient = restClient;
        this.objectMapper = objectMapper;
        this.weatherRepository = weatherRepository;
    }

    public Weather getWeatherByCity(String city, String appId) {
        Weather weather = new Weather();
        String weatherResp = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("q", city)
                        .queryParam("appid", appId)
                        .build())
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .toEntity(String.class)
                .getBody();
        try {
            JsonNode jsonNode = objectMapper.readTree(weatherResp);
            JsonNode mainNode = jsonNode.get("main");
            weather.setCity(jsonNode.path("name").asText());
            weather.setTemp(mainNode.path("temp").asText());
            weather.setTempMin(mainNode.path("temp_min").asText());
            weather.setTempMax(mainNode.path("temp").asText());
            weather.setHumidity(mainNode.path("humidity").asText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        weatherRepository.save(weather);
        return weather;
    }
}
