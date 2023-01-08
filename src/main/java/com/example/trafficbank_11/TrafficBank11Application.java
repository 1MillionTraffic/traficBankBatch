package com.example.trafficbank_11;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class TrafficBank11Application {

    public static void main(String[] args) {
        SpringApplication.run(TrafficBank11Application.class, args);
    }

}
