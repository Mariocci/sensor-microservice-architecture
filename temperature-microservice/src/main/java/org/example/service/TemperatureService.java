package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.Reading;
import org.example.repository.ReadingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureService {

    private final ReadingRepository repository;
    private List<Reading> readings;

    public TemperatureService(ReadingRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    void init() throws Exception {
        readings = repository.findAll();
    }

    public double getCurrentTemperature() {
        long seconds = System.currentTimeMillis() / 60000;
        int row = (int) ((seconds % 100));

        return readings.get(row).getTemperature();
    }
}
