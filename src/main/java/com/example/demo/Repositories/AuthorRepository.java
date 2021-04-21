package com.example.demo.Repositories;

import com.example.demo.Entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findAllByNameIgnoreCase(String name);
}
