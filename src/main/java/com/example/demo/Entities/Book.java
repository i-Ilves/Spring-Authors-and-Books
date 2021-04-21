package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table( name = "books")
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String title;

    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;

    public Book() {
        }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}


