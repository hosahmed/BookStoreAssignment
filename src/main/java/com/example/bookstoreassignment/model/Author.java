package com.example.bookstoreassignment.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    
    @Column(length = 1000)
    private String biography;

    public Author() {
    }

    public Author(String firstName, String lastName, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }

}
