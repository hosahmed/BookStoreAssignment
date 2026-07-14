package com.example.bookstoreassignment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookDTO {

    @NotBlank(message = "Title is mandatory")
    private String title;
    
    @NotNull(message = "Author ID is mandatory")
    private Long authorId;
    
    @NotBlank(message = "ISBN is mandatory")
    private String isbn;
    
    @Positive(message = "Price must be positive")
    private double price;

}
