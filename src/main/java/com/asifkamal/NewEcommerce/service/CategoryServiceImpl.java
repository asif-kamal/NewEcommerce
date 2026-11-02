package com.asifkamal.NewEcommerce.service;

import com.asifkamal.NewEcommerce.model.Category;
import com.asifkamal.NewEcommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    //private Long nextId = 1L;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        categoryRepository.delete(category);
        return "Category with ID of: " + categoryId + " deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

        optionalCategory.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Category not found!"));

        category.setCategoryId(categoryId);
        return categoryRepository.save(category);
    }
}
