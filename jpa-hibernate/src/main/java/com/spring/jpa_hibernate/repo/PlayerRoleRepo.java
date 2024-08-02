package com.spring.jpa_hibernate.repo;

import com.spring.jpa_hibernate.OnetoMany.UniDir.PlayerRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRoleRepo extends JpaRepository<PlayerRole,Integer> {
}
