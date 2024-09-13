package spring.kubernetes.spring_kubernetes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import spring.kubernetes.spring_kubernetes.entity.Book;
import spring.kubernetes.spring_kubernetes.repo.BookRepo;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class SpringKubernetesApplication {


	private final BookRepo repository;

	SpringKubernetesApplication(BookRepo bookRepository){
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
		SpringApplication.run(SpringKubernetesApplication.class, args);
	}

}
