package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.Reading;
import org.example.repository.HumidityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HumidityService {

    private final HumidityRepository repository;
    private List<Reading> readings;

    public HumidityService(HumidityRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    void init() throws Exception {
        readings = repository.findAll();
    }

    public double getCurrentTemperature() {
        long seconds = System.currentTimeMillis() / 60000;
        int row = (int) ((seconds % 100));

        return readings.get(row).getHumidity();
    }
}
