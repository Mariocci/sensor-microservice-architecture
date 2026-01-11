package org.example.controller;

import org.example.service.HumidityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/humidity")
public class HumidityController {

    private final HumidityService service;

    public HumidityController(HumidityService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> getHumidity() {
        return Map.of(
                "name", "Humidity",
                "unit", "%",
                "value", service.getCurrentHumidity()
        );
    }
}
