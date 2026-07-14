package com.example.bookstoreassignment.controller;

import com.example.bookstoreassignment.dto.BookDTO;
import com.example.bookstoreassignment.exception.ResourceNotFoundException;
import com.example.bookstoreassignment.model.Book;
import com.example.bookstoreassignment.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with isbn: " + isbn));
    }
}
