package com.spring.jpa_hibernate.repo;


import com.spring.jpa_hibernate.OnetoMany.UniDir.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player,Integer> {
}
