package org.example.repository;

import org.example.model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumidityRepository extends JpaRepository<Reading, Long> {
}