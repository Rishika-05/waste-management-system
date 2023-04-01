package com.se.wastemanagementsystem.repository;

import com.se.wastemanagementsystem.entity.WasteFacilitatorEntity;
import com.se.wastemanagementsystem.entity.WasteFacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasteFaciltyRepo extends JpaRepository<WasteFacilityEntity, Integer> {
    List<WasteFacilityEntity> findAll();


}
