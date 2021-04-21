package com.example.demo.Controllers;

import com.example.demo.Repositories.BookRepository;
import com.example.demo.Entities.Book;
import com.example.demo.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/api/books/{id}")
    public Optional<Book> getBook(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/api/pets/books/{name}")
    public List<Book> getAllBooksByTitle(@PathVariable String title) {
        return bookService.getAllBooksByTitle(title);
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteById(@PathVariable int id) {
        bookService.deleteById(id);
    }
}
