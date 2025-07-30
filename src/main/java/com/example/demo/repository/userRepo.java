package com.example.demo.repository;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.userEntity;

public interface userRepo extends JpaRepository<userEntity, Long>{
  boolean existsByPhoneNumber(String phoneNumber);
  
  Page<userEntity> findAll(Pageable pageable);
}
