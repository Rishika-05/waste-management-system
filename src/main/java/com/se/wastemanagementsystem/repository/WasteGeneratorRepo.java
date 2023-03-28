package com.se.wastemanagementsystem.repository;

import com.se.wastemanagementsystem.entity.WasteGeneratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteGeneratorRepo extends JpaRepository<WasteGeneratorEntity, Integer> {
    WasteGeneratorEntity findByUserId(Integer id);
}
