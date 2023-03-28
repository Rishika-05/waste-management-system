package com.se.wastemanagementsystem.repository;

import com.se.wastemanagementsystem.entity.WasteFacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteFaciltyRepo extends JpaRepository<WasteFacilityEntity, Integer> {
}
