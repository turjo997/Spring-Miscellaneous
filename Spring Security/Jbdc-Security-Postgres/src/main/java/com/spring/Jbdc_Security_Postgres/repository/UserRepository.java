package com.spring.Jbdc_Security_Postgres.repository;

import com.spring.Jbdc_Security_Postgres.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
}
