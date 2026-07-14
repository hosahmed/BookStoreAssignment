package com.example.bookstoreassignment.service;

import com.example.bookstoreassignment.dto.AuthorDTO;
import com.example.bookstoreassignment.exception.ResourceNotFoundException;
import com.example.bookstoreassignment.model.Author;
import com.example.bookstoreassignment.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setBiography(authorDTO.getBiography());
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
    }

    @Override
    public Author updateAuthor(Long id, AuthorDTO authorDTO) {
        Author existingAuthor = getAuthorById(id);
        existingAuthor.setFirstName(authorDTO.getFirstName());
        existingAuthor.setLastName(authorDTO.getLastName());
        existingAuthor.setBiography(authorDTO.getBiography());
        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
    }
}
