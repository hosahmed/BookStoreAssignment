package com.example.bookstoreassignment.service;

import com.example.bookstoreassignment.dto.BookDTO;
import com.example.bookstoreassignment.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(BookDTO bookDTO);
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    Book updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
    Optional<Book> getBookByIsbn(String isbn);
}
