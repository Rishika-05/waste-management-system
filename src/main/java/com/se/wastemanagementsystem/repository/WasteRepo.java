package com.se.wastemanagementsystem.repository;


import com.se.wastemanagementsystem.entity.WasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WasteRepo extends JpaRepository<WasteEntity, Integer> {
    List<WasteEntity> findAll();
    List<WasteEntity> findAllByGeneratedAtAfter(LocalDateTime dt);

    WasteEntity findByWgId(Integer id);
    List<WasteEntity> findAllByGeneratedAtAfterAndCollectionRequestedTrue(LocalDateTime dt);

    List<WasteEntity> findAllByGeneratedAtAfterAndTransportedTrue(LocalDateTime dt);

    List<WasteEntity> findAllByGeneratedAtAfterAndWgId(LocalDateTime dt, Integer id);

    List<WasteEntity> findAllByWgId(Integer id);

    List<WasteEntity> findAllByIdIn(List<Integer> wasteIds);
}
