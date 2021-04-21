package com.example.demo.Services;

import com.example.demo.Entities.Book;
import com.example.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooksByTitle(String title) {
        return bookRepository.findAllByTitleIgnoreCase(title);
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    public void updateBook(int id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            bookRepository.save(book);
        }
    }
}
