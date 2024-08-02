package com.spring.jpa_hibernate.repo;


import com.spring.jpa_hibernate.ManytoOne.bi.ActorRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRoleRepo extends JpaRepository<ActorRole,Integer> {
}
