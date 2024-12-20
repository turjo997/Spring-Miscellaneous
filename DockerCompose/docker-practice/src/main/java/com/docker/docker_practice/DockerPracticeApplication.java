package com.docker.docker_practice;

import com.docker.docker_practice.entity.Book;
import com.docker.docker_practice.repo.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class DockerPracticeApplication {

	private final BookRepository repository;

	DockerPracticeApplication(BookRepository bookRepository){
		this.repository = bookRepository;
	}

	@PostMapping("/save")
	public Book saveBook(@RequestBody Book book){
	//	System.out.println("Book received: " + book.getAuthorName());
		return repository.save(book);
	}

	@GetMapping
	public List<Book> getBooks(){
		return repository.findAll();
	}


	@GetMapping("/message")
	public String message(){
		return "Hello from docker...";
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerPracticeApplication.class, args);
	}

}
