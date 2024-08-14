package org.arghya.weatherapi.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.arghya.weatherapi.model.Weather;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherRepository {
    DynamoDBMapper dynamoDBMapper;

    public WeatherRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void save( Weather weather) {
        dynamoDBMapper.save(weather);
    }

    public Weather get(String city) {
        return dynamoDBMapper.load(Weather.class, city);
    }
}
