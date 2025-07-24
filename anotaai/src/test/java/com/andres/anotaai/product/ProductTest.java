package com.andres.anotaai.product;

import com.andres.anotaai.domain.product.Product;
import com.andres.anotaai.exception.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void givenAValidParams_whenCreateNewProduct_shouldCreate() {
        final var title = "Product Title";
        final var owner = "Owner Name";
        final var category = "Category Name";
        final var inputPrice = 19.99;
        final var savedPrice = 1999;
        final var description = "Product Description";

        final var product = Product.newProduct(title, owner, category, inputPrice, description);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(title, product.getTitle());
        Assertions.assertEquals(owner, product.getOwner());
        Assertions.assertEquals(category, product.getCategory());
        Assertions.assertEquals(savedPrice, product.getPrice());
        Assertions.assertEquals(description, product.getDescription());
        Assertions.assertNotNull(product.getId());
        Assertions.assertNotNull(product.getCreatedAt());
        Assertions.assertNotNull(product.getUpdatedAt());
        Assertions.assertNull(product.getDeletedAt());
    }

    @Test
    void givenAValidParamsWithNullDescription_whenCreateNewProduct_shouldCreate() {
        final var title = "Product Title";
        final var owner = "Owner Name";
        final var category = "Category Name";
        final var inputPrice = 19.99;
        final var savedPrice = 1999;
        final String description = null;

        final var product = Product.newProduct(title, owner, category, inputPrice, description);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(title, product.getTitle());
        Assertions.assertEquals(owner, product.getOwner());
        Assertions.assertEquals(category, product.getCategory());
        Assertions.assertEquals(savedPrice, product.getPrice());
        Assertions.assertNull(description, product.getDescription());
        Assertions.assertNotNull(product.getId());
        Assertions.assertNotNull(product.getCreatedAt());
        Assertions.assertNotNull(product.getUpdatedAt());
        Assertions.assertNull(product.getDeletedAt());
    }

    @Test
    void givenAInvalidTitle_whenCreateNewProduct_shouldReturnDomainException() {
        String title = null;
        final var owner = "Owner Name";
        final var category = "Category Name";
        final var inputPrice = 19.99;
        final String description = null;
        final var expectedErrorMessage = "'title' cannot be empty";

        final var actualException = Assertions.assertThrows(
            DomainException.class,
            () -> Product.newProduct(title, owner, category, inputPrice, description)
        );

        Assertions.assertNotNull(actualException);
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());
    }

    @Test
    void givenAInvalidOwner_whenCreateNewProduct_shouldReturnDomainException() {
        final var title = "Product Title";
        String owner = null;
        final var category = "Category Name";
        final var price = 19.99;
        final String description = null;
        final var expectedErrorMessage = "'owner' cannot be empty";

        final var actualException = Assertions.assertThrows(
                DomainException.class,
                () -> Product.newProduct(title, owner, category, price, description)
        );

        Assertions.assertNotNull(actualException);
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());
    }

    @Test
    void givenAInvalidCategory_whenCreateNewProduct_shouldReturnDomainException() {
        final var title = "Product Title";
        final var owner = "Owner Name";
        String category = null;
        final var price = 19.99;
        final String description = null;
        final var expectedErrorMessage = "'category' cannot be empty";

        final var actualException = Assertions.assertThrows(
                DomainException.class,
                () -> Product.newProduct(title, owner, category, price, description)
        );

        Assertions.assertNotNull(actualException);
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());
    }

    @Test
    void givenAInvalidPrice_whenCreateNewProduct_shouldReturnDomainException() {
        final var title = "Product Title";
        final var owner = "Owner Name";
        final var category = "Category Name";
        Double price = null;
        final String description = null;
        String expectedErrorMessage = "'price' cannot be null";

        var actualException = Assertions.assertThrows(
                DomainException.class,
                () -> Product.newProduct(title, owner, category, price, description)
        );

        Assertions.assertNotNull(actualException);
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

        var negativePrice = -10.0;
        expectedErrorMessage = "'price' must be greater than zero";
        actualException = Assertions.assertThrows(
                DomainException.class,
                () -> Product.newProduct(title, owner, category, negativePrice, description)
        );

        Assertions.assertNotNull(actualException);
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

    }

}
