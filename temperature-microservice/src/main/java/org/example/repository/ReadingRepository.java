package org.example.repository;

import org.example.model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingRepository
        extends JpaRepository<Reading, Long> {
}