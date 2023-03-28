package com.se.wastemanagementsystem.repository;

import com.se.wastemanagementsystem.entity.GovtOfficialEntity;
import com.se.wastemanagementsystem.entity.WasteCollectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovtOfficialRepo extends JpaRepository<GovtOfficialEntity, Integer> {
    GovtOfficialEntity findByUserId(Integer id);
}
