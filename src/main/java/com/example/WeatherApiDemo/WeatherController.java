package com.example.WeatherApiDemo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class WeatherController {

    @GetMapping("/weather")
    public ResponseEntity<?> getWeather() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://jsonplaceholder.typicode.com/posts";
            JsonNode postData = restTemplate.getForObject(url, JsonNode.class);
            return new ResponseEntity<>(postData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching post data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
