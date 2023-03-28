package com.se.wastemanagementsystem.repository;

import com.se.wastemanagementsystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByPhoneNo(String no);

    Optional<UserEntity> findById(Integer id);

}
