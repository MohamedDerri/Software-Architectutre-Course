package derri.org.bookApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import derri.org.bookApplication.domain.Book;
import derri.org.bookApplication.repository.BookRepository;



@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(String isbn) {
        bookRepository.deleteById(isbn);
    }

    public Book getBook(String isbn) {
        return bookRepository.findById(isbn).orElse(null);
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
