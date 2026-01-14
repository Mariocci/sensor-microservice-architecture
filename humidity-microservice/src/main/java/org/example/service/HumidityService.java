package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.Reading;
import org.example.repository.HumidityRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class HumidityService {

    private final HumidityRepository repository;
    private List<Reading> readings;

    @Value("${readings.path:/config/readings.csv}")
    private String csvPath;

    public HumidityService(HumidityRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    void loadCsv() throws Exception {
        try (BufferedReader br = Files.newBufferedReader(Path.of(csvPath))) {
            br.lines()
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(cols -> new Reading(
                            Double.parseDouble(cols[0]) // humidity
                    ))
                    .forEach(repository::save);
        }
        readings = repository.findAll();
    }

    public double getCurrentHumidity() {
        long minutes = System.currentTimeMillis() / 60000;
        int row = (int) (minutes % readings.size());

        return readings.get(row).getHumidity();
    }
}
