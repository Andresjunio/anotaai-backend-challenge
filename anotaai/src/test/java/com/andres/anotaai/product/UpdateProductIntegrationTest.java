package com.andres.anotaai.product;


import com.andres.anotaai.controller.product.ProductController;
import com.andres.anotaai.domain.product.Product;
import com.andres.anotaai.domain.product.ProductDTO;
import com.andres.anotaai.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(controllers = ProductController.class)
public class UpdateProductIntegrationTest {

//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private ObjectMapper mapper;
//
//    @MockitoBean
//    private ProductService productService;

//    @Test
//    void shouldUpdateProduct() throws Exception {
//        final var productId = UUID.randomUUID().toString();
//        final var oldTitle = "Old Product Title";
//        final var updatedTitle = "Updated Product Title";
//        final var owner = "Owner 123";
//        final var description = "Updated Product Description";
//        final var price = 19.99;
//        final var categoryId = UUID.randomUUID().toString();
//        final var oldProduct = Product.newProduct(oldTitle, owner, categoryId, price, description);
//        final var updatedProduct = new ProductDTO(updatedTitle, owner, categoryId, price, description);
//
//        when(productService.getProductById(productId)).thenReturn(oldProduct);
//
//        var requestBody = mapper.writeValueAsString(updatedProduct);

//        MvcResult result = mvc.perform(put("/api/products/update/{id}", productId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andReturn();
//        MvcResult result = mvc.perform(put("/api/products/update/{id}", productId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(productId))
//                .andExpect(jsonPath("$.title").value(updatedTitle))
//                .andExpect(jsonPath("$.owner").value(owner))
//                .andExpect(jsonPath("$.category").value(categoryId))
//                .andExpect(jsonPath("$.price").value(price)) // Assumindo que o JSON retorna o preço como 19.99
//                .andExpect(jsonPath("$.description").value(description))
//                .andExpect(jsonPath("$.createdAt").exists())
//                .andExpect(jsonPath("$.createdAt").exists()) // Alternativa para 'exists'
//                .andExpect(jsonPath("$.updatedAt").exists()) // Garante que o campo de update também existe
//                .andExpect(jsonPath("$.deletedAt").isEmpty()) // Verifica se o campo é nulo ou ausente
//                .andReturn(); // Retorna o resultado para a asserção complexa

//        String responseBody = result.getResponse().getContentAsString();
//
//        Product returnedProduct = mapper.readValue(responseBody, Product.class);
//        Assertions.assertNotNull(returnedProduct);
//        Assertions.assertNotNull(returnedProduct.getId());
//        Assertions.assertEquals(productId, returnedProduct.getId());
//        Assertions.assertEquals(updatedTitle, returnedProduct.getTitle());
//        Assertions.assertEquals(owner, returnedProduct.getOwner());
//        Assertions.assertEquals(categoryId, returnedProduct.getCategory());
//        Assertions.assertEquals(price, (double) returnedProduct.getPrice() /100);
//        Assertions.assertEquals(description, returnedProduct.getDescription());
//        Assertions.assertNotNull(returnedProduct.getCreatedAt());
//        Assertions.assertTrue(returnedProduct.getCreatedAt().isBefore(returnedProduct.getUpdatedAt()));
//        Assertions.assertNull(returnedProduct.getDeletedAt());

//        verify(productService, times(1)).getProductById(productId);
//        verify(productService, times(1)).updateProduct(eq(productId), any(ProductDTO.class));

//    }


}
