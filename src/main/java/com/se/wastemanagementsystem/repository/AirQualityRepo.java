package com.se.wastemanagementsystem.repository;

import com.se.wastemanagementsystem.entity.AirQualityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AirQualityRepo extends JpaRepository<AirQualityEntity, Integer> {
    List<AirQualityEntity> findAllByRecordedAtAfter(LocalDate dt);
}
