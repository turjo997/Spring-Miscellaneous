package com.spring.jpa_hibernate.repo;


import com.spring.jpa_hibernate.ManytoOne.uni.Actress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActressRepo extends JpaRepository<Actress,Integer> {
}
