package com.spring.Jdbc_Security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<RoleRepo,Integer> {
    Optional findByRoleName(String name);
}
