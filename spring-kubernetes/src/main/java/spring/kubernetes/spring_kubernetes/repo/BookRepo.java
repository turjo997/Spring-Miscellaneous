package spring.kubernetes.spring_kubernetes.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.kubernetes.spring_kubernetes.entity.Book;
@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
