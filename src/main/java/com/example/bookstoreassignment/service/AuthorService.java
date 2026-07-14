package com.example.bookstoreassignment.service;

import com.example.bookstoreassignment.dto.AuthorDTO;
import com.example.bookstoreassignment.model.Author;
import java.util.List;

public interface AuthorService {
    Author createAuthor(AuthorDTO authorDTO);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
    Author updateAuthor(Long id, AuthorDTO authorDTO);
    void deleteAuthor(Long id);
}
