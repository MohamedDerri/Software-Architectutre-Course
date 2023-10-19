package derri.org.bookApplication.repository;
import org.springframework.data.repository.CrudRepository;

import derri.org.bookApplication.domain.Book;

public interface BookRepository extends CrudRepository<Book, String> {
}
