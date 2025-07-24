package com.andres.anotaai.service;

import com.andres.anotaai.domain.product.Product;
import com.andres.anotaai.domain.product.ProductDTO;
import com.andres.anotaai.exception.BadRequestException;
import com.andres.anotaai.exception.DomainException;
import com.andres.anotaai.exception.ProductNotFoundException;
import com.andres.anotaai.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product createProduct(final ProductDTO data) {
        Product product = Product.newProduct(data.title(), data.owner(), data.categoryId(), data.price(), data.description());
        return repository.save(product);
    }

    public Product getProductById(final String id) {
        if(id == null || id.isBlank())
            throw new BadRequestException("'id' cannot be null or empty");

        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("cannot find product with id " + id));
    }

    public Product updateProduct(final String id, final ProductDTO data) {
        if(id == null || id.isBlank())
            throw new BadRequestException("'id' cannot be null or empty");

        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("cannot find product with id " + id));

        product.update(data.title(), data.owner(), data.categoryId(), data.price(), data.description());
        return repository.save(product);
    }

    public void deleteProduct(final String id) {
        if(id == null || id.isBlank())
            throw new BadRequestException("'id' cannot be null or empty");

        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("cannot find product with id " + id));
        repository.delete(product);
    }

}
