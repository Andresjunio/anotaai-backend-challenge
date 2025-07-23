package com.andres.anotaai.category;

import com.andres.anotaai.domain.Category;
import com.andres.anotaai.exception.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    void givenAValidParams_whenCallsCreateCategory_shouldReturnCategory() {
        final var expectedTitle = "Category Title";
        final var expectedDescription = "Category Description";
        final var expectedOwnerID = "12345";

        final var actualCategory = Category.newCategory(expectedTitle,expectedDescription, expectedOwnerID);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedTitle, actualCategory.getTitle());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedOwnerID, actualCategory.getOwnerId());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    void givenANullDescription_whenCallsCreateCategory_shouldReturnCategory() {
        final var expectedTitle = "Category Title";
        String expectedDescription = null;
        final var expectedOwnerID = "12345";

        final var actualCategory = Category.newCategory(expectedTitle,expectedDescription, expectedOwnerID);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedTitle, actualCategory.getTitle());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedOwnerID, actualCategory.getOwnerId());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    void givenAInvalidTitle_whenCallsCreateCategory_shouldThrowDomainException() {
        final String expectedTitle = null;
        final String expectedDescription = "Category Description";
        final String expectedOwnerID = "12345";
        final var expectedErrorMessage = "'title' should not be empty";

        final var actualException = Assertions.assertThrows(
                DomainException.class,
                () -> Category.newCategory(expectedTitle, expectedDescription, expectedOwnerID)
        );

        Assertions.assertNotNull(actualException);
        Assertions.assertEquals(actualException.getMessage(), expectedErrorMessage);
    }

    @Test
    void givenAInvalidOwnerID_whenCallsCreateCategory_shouldThrowDomainException() {
        final String expectedTitle = "Category Title";
        final String expectedDescription = "Category Description";
        String expectedOwnerID = null;
        final var expectedErrorMessage = "'ownerId' should not be empty";

        final var actualException = Assertions.assertThrows(
                DomainException.class,
                () -> Category.newCategory(expectedTitle, expectedDescription, expectedOwnerID)
        );

        Assertions.assertNotNull(actualException);
        Assertions.assertEquals(actualException.getMessage(), expectedErrorMessage);
    }

}
