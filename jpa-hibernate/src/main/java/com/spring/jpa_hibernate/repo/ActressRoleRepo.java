package com.spring.jpa_hibernate.repo;


import com.spring.jpa_hibernate.ManytoOne.uni.ActressRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActressRoleRepo extends JpaRepository<ActressRole,Integer> {
}
