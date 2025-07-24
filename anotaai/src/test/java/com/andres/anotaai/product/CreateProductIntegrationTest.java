package com.andres.anotaai.product;

import com.andres.anotaai.controller.product.ProductController;
import com.andres.anotaai.domain.product.ProductDTO;
import com.andres.anotaai.exception.DomainException;
import com.andres.anotaai.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
public class CreateProductIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockitoBean
    private ProductService service;

    @Test
    void shouldCreateProduct() throws Exception {
        final var title = "Test Product";
        final var owner = "owner123";
        final var categoryId = "category123";
        final var price = 19.99;
        final var description = "This is a test product";

        final var product = new ProductDTO(title, owner, categoryId, price, description);
        final var requestBody = mapper.writeValueAsString(product);

        mvc.perform(post("/api/products/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated());

    }

    @Test
    void shouldCreateProductWithNullDescription() throws Exception {
        final var title = "Test Product";
        final var owner = "owner123";
        final var categoryId = "category123";
        final var price = 19.99;

        var product = new ProductDTO(title, owner, categoryId, price, null);
        var requestBody = mapper.writeValueAsString(product);

        mvc.perform(post("/api/products/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated());

    }

    @Test
    void shouldReturnUnprocessableEntityWhenTitleIsInvalid() throws Exception {
        final var owner = "owner123";
        final var categoryId = "category123";
        final var price = 19.99;

        final var product = new ProductDTO(null, owner, categoryId, price, null);
        final var requestBody = mapper.writeValueAsString(product);

        when(service.createProduct(any(ProductDTO.class)))
                .thenThrow(new DomainException("'title' cannot be empty"));

        mvc.perform(post("/api/products/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());

    }

    @Test
    void shouldReturnUnprocessableEntityWhenOwnerIsInvalid() throws Exception {
        final var title = "Test Product";
        final var categoryId = "category123";
        final var price = 19.99;

        final var product = new ProductDTO(title,null, categoryId, price, null);
        final var requestBody = mapper.writeValueAsString(product);

        when(service.createProduct(any(ProductDTO.class)))
                .thenThrow(new DomainException("'owner' cannot be empty"));

        mvc.perform(post("/api/products/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());

    }

    @Test
    void shouldReturnUnprocessableEntityWhenCategoryIdIsInvalid() throws Exception {
        final var title = "Test Product";
        final var owner = "owner123";
        final var price = 19.99;

        final var product = new ProductDTO(title,owner,null, price, null);
        final var requestBody = mapper.writeValueAsString(product);

        when(service.createProduct(any(ProductDTO.class)))
                .thenThrow(new DomainException("'category' cannot be empty"));

        mvc.perform(post("/api/products/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());

    }

    @Test
    void shouldReturnUnprocessableEntityWhenPriceIsInvalid() throws Exception {
        final var title = "Test Product";
        final var owner = "owner123";
        final var categoryId = "category123";
        final var price = -19.99;

        var product = new ProductDTO(title, owner, categoryId, price, null);
        var requestBody = mapper.writeValueAsString(product);

        mvc.perform(post("/api/products/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isUnprocessableEntity());

    }

}
