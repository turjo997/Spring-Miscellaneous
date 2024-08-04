package com.spring.Jbdc_Security_Postgres.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.spring.Jbdc_Security_Postgres.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role , Integer> {
    Optional<Role> findByRoleName(String name);
}
