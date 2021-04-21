package com.example.demo.Controllers;

import com.example.demo.Entities.Author;
import com.example.demo.Entities.Book;
import com.example.demo.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/api/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/api/authors/name/{name}")
    public List<Author> getAllAuthorsByName(@PathVariable String name) {
        return authorService.getAllAuthorsByName(name);
    }

    @PostMapping("/api/authors")
    public Author addNewAuthor(@RequestBody Author author) {
        return authorService.addNewAuthor(author);
    }

    @DeleteMapping("/api/authors/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
    }

    @PutMapping("/api/authors/{id}")
    public void updateAuthor(@PathVariable int id, @RequestBody Author author) {
        authorService.updateAuthor(id, author);
    }

    @PostMapping("/api/authors/{id}")
    public void addBookToAuthor(@PathVariable int id, @RequestBody Book book) {
        authorService.addBookToAuthor(id, book);
    }
}


