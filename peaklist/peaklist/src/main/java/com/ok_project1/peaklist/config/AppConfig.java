package com.ok_project1.peaklist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
@Configuration
public class AppConfig {

    @Bean
    public RestClient overpassRC() {
        return RestClient.builder().baseUrl("https://overpass-api.de/api/interpreter").build();

    }
}
