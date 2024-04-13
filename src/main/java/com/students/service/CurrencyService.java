package com.students.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.students.DTO.CurrencyDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
//can replace @RequiredArgsConstructor
//    public CurrencyService(ObjectMapper mapper, RestTemplate restTemplate) {
//        this.mapper = mapper;
//        this.restTemplate = restTemplate;
//    }
    private final String URL = "https://www.cbr-xml-daily.ru/daily_json.js";

    @PostConstruct
    public void init() throws JsonProcessingException {
        String response = restTemplate.getForObject(URL, String.class);
        CurrencyDTO dto = objectMapper.readValue(response, CurrencyDTO.class);
    }
}
