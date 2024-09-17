package com.spring.entity_data_validation.repo;

import com.spring.entity_data_validation.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author , Integer> {
}
