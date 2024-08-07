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

    public Weather save( Weather weather) {
        dynamoDBMapper.save(weather);
        return weather;
    }

//    public Weather get(String city) {
//        dynamoDBMapper.
//    }
}
