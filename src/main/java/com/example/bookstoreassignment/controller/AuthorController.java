package com.example.bookstoreassignment.controller;

import com.example.bookstoreassignment.dto.AuthorDTO;
import com.example.bookstoreassignment.model.Author;
import com.example.bookstoreassignment.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
    
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorDTO authorDTO) {
        return authorService.updateAuthor(id, authorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
}
