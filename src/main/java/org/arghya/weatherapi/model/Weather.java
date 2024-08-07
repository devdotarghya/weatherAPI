package org.arghya.weatherapi.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "weather")
public class Weather {
    @DynamoDBHashKey
    private String city;
    @DynamoDBAttribute
    private String temp;
    @DynamoDBAttribute
    private String tempMin;
    @DynamoDBAttribute
    private String tempMax;
    @DynamoDBAttribute
    private String humidity;
}
