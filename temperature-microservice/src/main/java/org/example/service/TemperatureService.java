package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.Reading;
import org.example.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class TemperatureService {

    private final ReadingRepository repository;
    private List<Reading> readings;

    @Value("${readings.path:/config/readings.csv}")
    private String csvPath;

    public TemperatureService(ReadingRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    void loadCsv() throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Path.of(csvPath))) {
            br.lines()
                    .skip(1) // header
                    .map(line -> line.split(","))
                    .map(cols -> new Reading(
                            Double.parseDouble(cols[0])
                    ))
                    .forEach(repository::save);
        }
        readings = repository.findAll();
    }

    public double getCurrentTemperature() {
        long minutes = System.currentTimeMillis() / 60000;
        int row = (int) ((minutes % 100) + 1);

        return readings.get(row % readings.size()).getTemperature();
    }
}