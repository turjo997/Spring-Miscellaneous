package spring.kubernetes.spring_kubernetes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.kubernetes.spring_kubernetes.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
