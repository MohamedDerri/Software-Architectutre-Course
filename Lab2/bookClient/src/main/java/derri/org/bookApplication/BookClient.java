package derri.org.bookApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import derri.org.bookApplication.domain.Book;

@SpringBootApplication
public class BookClient {

    public static void main(String[] args) {
        SpringApplication.run(BookClient.class, args);

        // Create a new RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Base URL of the Book management system's RESTful API
        String baseUrl = "http://localhost:8080/books";

        // Add a book
        Book newBook = new Book("12345", "mohamed", "hands on machine learning", 399.99);
        ResponseEntity<Book> addResponse = restTemplate.postForEntity(baseUrl, newBook, Book.class);
        if (addResponse.getStatusCode() == HttpStatus.CREATED) {
            System.out.println("Book added successfully: " + addResponse.getBody());
        }

        // Get a book
        ResponseEntity<Book> getResponse = restTemplate.getForEntity(baseUrl + "/12345", Book.class);
        if (getResponse.getStatusCode() == HttpStatus.OK) {
            System.out.println("Retrieved book: " + getResponse.getBody());
        }

        // Update a book
        Book updatedBook = getResponse.getBody();
        if (updatedBook != null) {
            updatedBook.setTitle("Updated Title");
            restTemplate.put(baseUrl + "/12345", updatedBook);
            System.out.println("Book updated successfully");
        }

        // Get all books
        ResponseEntity<Book[]> getAllResponse = restTemplate.getForEntity(baseUrl, Book[].class);
        if (getAllResponse.getStatusCode() == HttpStatus.OK) {
            Book[] books = getAllResponse.getBody();
            System.out.println("All Books:");
            for (Book book : books) {
                System.out.println(book);
            }
        }

        // Delete a book
        restTemplate.delete(baseUrl + "/12345");
        System.out.println("Book deleted successfully");
    }
}
