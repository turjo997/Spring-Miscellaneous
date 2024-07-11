package com.spring.docker_mysql.repository;


import com.spring.docker_mysql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
