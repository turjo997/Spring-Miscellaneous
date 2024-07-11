package com.spring.docker_mysql;


import com.spring.docker_mysql.model.Book;
import com.spring.docker_mysql.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@RestController
@RequestMapping("/book")
public class DockerMysqlApplication {


	private final BookRepository repository;

	DockerMysqlApplication(BookRepository bookRepository){
		this.repository = bookRepository;
	}

	@PostMapping
	public Book saveBook(@RequestBody Book book){
		return repository.save(book);
	}

	@GetMapping
	public List<Book> getBooks(){
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerMysqlApplication.class, args);
	}

}
