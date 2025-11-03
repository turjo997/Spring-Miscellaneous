package com.iwl.multi_tenant_mvc.repo;

import com.iwl.multi_tenant_mvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
