package com.andres.anotaai.service;

import com.andres.anotaai.domain.category.Category;
import com.andres.anotaai.domain.category.CategoryDTO;
import com.andres.anotaai.exception.BadRequestException;
import com.andres.anotaai.exception.CategoryNotFoundException;
import com.andres.anotaai.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(final CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category createCategory(final CategoryDTO category) {
        Category newCategory = Category.newCategory(category.title(), category.description(), category.ownerId());
        return repository.save(newCategory);
    }

    public Category getCategoryById(final String id) {
        if (id == null || id.isBlank()) {
            throw new BadRequestException("'id' cannot be null or empty");
        }
        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("cannot find category with id " + id));
    }

    public Category updateCategory(final String id, final CategoryDTO category) {
        if (id == null || id.isBlank()) {
            throw new BadRequestException("'id' cannot be null or empty");
        }

        Category existingCategory = repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("cannot find category with id " + id));

        existingCategory.update(category.title(), category.description(), category.ownerId());
        return repository.save(existingCategory);
    }

    public void deleteCategory(final String id) {
        if (id == null || id.isBlank()) {
            throw new BadRequestException("'id' cannot be null or empty");
        }

        Category category = repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("cannot find category with id " + id));
        repository.delete(category);
    }





}
