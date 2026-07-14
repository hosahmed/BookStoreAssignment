package com.example.bookstoreassignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
    
    @Column(unique = true)
    private String isbn;
    
    private double price;

    public Book() {
    }

    public Book(String title, Author author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

}
