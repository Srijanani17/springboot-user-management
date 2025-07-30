package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.roleEntity;

public interface roleRepo extends JpaRepository<roleEntity, Long>{
	Optional<roleEntity> findByRoleName(String roleName);
}
