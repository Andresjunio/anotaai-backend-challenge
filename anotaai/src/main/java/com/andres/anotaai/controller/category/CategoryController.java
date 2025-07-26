package com.andres.anotaai.controller.category;

import com.andres.anotaai.domain.category.Category;
import com.andres.anotaai.domain.category.CategoryDTO;
import com.andres.anotaai.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(final CategoryService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Category> getAllProducts() {
        return service.getAllCategories();
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createProduct(@Valid @RequestBody CategoryDTO category) {
        final Category createdCategory = service.createCategory(category);
        return new ResponseEntity<Category>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Category> getProductById(@PathVariable String id) {
        Category category = service.getCategoryById(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateProduct(@PathVariable String id, @Valid @RequestBody CategoryDTO category) {
        Category updatedCategory = service.updateCategory(id, category);
        return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        service.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
