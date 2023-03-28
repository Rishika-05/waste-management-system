package com.se.wastemanagementsystem.repository;

import com.se.wastemanagementsystem.entity.WasteCollectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCollectorRepo extends JpaRepository<WasteCollectorEntity, Integer> {
    WasteCollectorEntity findByUserId(Integer id);
}
