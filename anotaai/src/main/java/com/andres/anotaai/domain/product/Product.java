package com.andres.anotaai.domain.product;

import com.andres.anotaai.exception.DomainException;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@Document(collection = "product")
public class Product {
    private String id;
    private String title;
    private String owner;
    private String category;
    private Integer price;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private Product(final String title,final String owner,final String category,final Integer price,final String description) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.owner = owner;
        this.category = category;
        this.price = price;
        this.description = description;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.deletedAt = null;
    }

    public static Product newProduct(final String title,final String owner,final String category,final Double price,final String description) {
        validate(title, owner, category, price);
        final var priceInteger = (int) Math.round(price * 100);
        return new Product(title, owner, category, priceInteger, description);
    }

    public Product update(final String title,final String owner,final String category,final Double price,final String description) {
        validate(title, owner, category, price);
        final var priceInteger = (int) Math.round(price * 100);
        this.title = title;
        this.owner = owner;
        this.category = category;
        this.price = priceInteger;
        this.description = description;
        this.updatedAt = Instant.now();
        return this;
    }

    private static void validate(String title, String owner, String category, Double price) {
        if (title == null || title.isBlank())
            throw new DomainException("'title' cannot be empty");

        if( owner == null || owner.isBlank())
            throw new DomainException("'owner' cannot be empty");

        if (category == null || category.isBlank())
            throw new DomainException("'category' cannot be empty");

        if(price == null)
            throw new DomainException("'price' cannot be null");

        if(price <= 0)
            throw new DomainException("'price' must be greater than zero");
    }


}
