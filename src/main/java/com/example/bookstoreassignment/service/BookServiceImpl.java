package com.example.bookstoreassignment.service;

import com.example.bookstoreassignment.dto.BookDTO;
import com.example.bookstoreassignment.exception.ResourceNotFoundException;
import com.example.bookstoreassignment.model.Author;
import com.example.bookstoreassignment.model.Book;
import com.example.bookstoreassignment.repository.AuthorRepository;
import com.example.bookstoreassignment.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book createBook(BookDTO bookDTO) {
        Author author = authorRepository.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + bookDTO.getAuthorId()));
        
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(author);
        book.setIsbn(bookDTO.getIsbn());
        book.setPrice(bookDTO.getPrice());
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        
        Author author = authorRepository.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + bookDTO.getAuthorId()));

        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(author);
        existingBook.setIsbn(bookDTO.getIsbn());
        existingBook.setPrice(bookDTO.getPrice());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
