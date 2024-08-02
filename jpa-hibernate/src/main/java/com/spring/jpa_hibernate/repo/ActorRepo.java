package com.spring.jpa_hibernate.repo;


import com.spring.jpa_hibernate.ManytoOne.bi.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepo extends JpaRepository<Actor,Integer> {
}
