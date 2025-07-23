package com.andres.anotaai.domain;


import com.andres.anotaai.exception.DomainException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Category {

    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Category(final String title,final String description,final String ownerId) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.ownerId = ownerId;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.deletedAt = null;
    }

    public static Category newCategory(final String title,final String description,final String ownerId) {
        if (title == null || title.isBlank()) {
            throw new DomainException("'title' should not be empty");
        }

        if (ownerId == null || ownerId.isBlank()) {
            throw new DomainException("'ownerId' should not be empty");
        }

        return new Category(title, description, ownerId);
    }

}
