package com.example.bookstoreassignment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthorDTO {

    @NotBlank(message = "First name is mandatory")
    private String firstName;
    
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    
    private String biography;

}
