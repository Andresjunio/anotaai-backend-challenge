package com.andres.anotaai.domain.product;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record ProductDTO(
        @Size(max = 150, message = "'title' must have less than 150 characters") String title,
        @Size(max = 150,  message = "'owner' must have less than 150 characters") String owner,
        String categoryId,
        @PositiveOrZero Double price,
        @Size(max = 250,  message = "'message' must have less than 250 characters") String description
) {
}
