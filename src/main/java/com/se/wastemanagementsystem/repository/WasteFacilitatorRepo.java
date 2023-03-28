package com.se.wastemanagementsystem.repository;

import com.se.wastemanagementsystem.entity.WasteFacilitatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteFacilitatorRepo extends JpaRepository<WasteFacilitatorEntity, Integer> {
    WasteFacilitatorEntity findByUserId(Integer id);
}
