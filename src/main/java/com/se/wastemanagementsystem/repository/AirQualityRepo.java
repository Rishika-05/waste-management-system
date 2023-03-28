package com.se.wastemanagementsystem.repository;

import com.se.wastemanagementsystem.entity.AirQualityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirQualityRepo extends JpaRepository<AirQualityEntity, Integer> {
}
