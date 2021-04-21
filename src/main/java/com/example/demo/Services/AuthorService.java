package com.example.demo.Services;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.Book;
import com.example.demo.Repositories.AuthorRepository;
import com.example.demo.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public List<Author> getAllAuthorsByName(String name) {
        return authorRepository.findAllByNameIgnoreCase(name);
    }

    public Author addNewAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    public void updateAuthor(int id, Author author) {
        if (authorRepository.existsById(id)) {
            author.setId(id);
            authorRepository.save(author);
        }
    }

    public void addBookToAuthor(int id, Book book) {
        if (authorRepository.existsById(id)) {
            Author parent = new Author();
            parent.setId(id);
            book.setAuthor(parent);
            bookRepository.save(book);
        }
    }
}
