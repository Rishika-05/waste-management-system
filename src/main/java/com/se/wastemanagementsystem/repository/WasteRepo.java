package com.se.wastemanagementsystem.repository;


import com.se.wastemanagementsystem.entity.WasteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteRepo extends JpaRepository<WasteEntity, Integer> {

}
