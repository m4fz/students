package com.students.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CurrencyConfig {
    @Bean("RestTemplate")
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean("ObjectMapper")
    public ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}
