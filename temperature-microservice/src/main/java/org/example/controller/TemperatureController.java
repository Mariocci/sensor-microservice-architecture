package org.example.controller;

import org.example.service.TemperatureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    private final TemperatureService service;

    public TemperatureController(TemperatureService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> read() {
        return Map.of(
                "name", "Temperature",
                "unit", "C",
                "value", service.getCurrentTemperature()
        );
    }
}
