package org.arghya.weatherapi.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfig {

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        return new DynamoDBMapper(buildDynamoDb());
    }

    private AmazonDynamoDB buildDynamoDb() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-1.amazonaws.com", "us-east-1")
                ).
                withCredentials(
                        new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIA4276TQAN7LEJIOHN", "5kVbEpTuknDS9tyqNNlXrifsTJxUG2jumgywyhVZ"))
                ).build();
    }
}
