package com.spring.file_operations2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FileOperations2Application {

	@GetMapping("/test")
	public String test() {
		return "Hello, world!";
	}
	public static void main(String[] args) {
		SpringApplication.run(FileOperations2Application.class, args);
	}

}
