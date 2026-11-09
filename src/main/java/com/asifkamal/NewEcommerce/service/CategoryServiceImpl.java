package com.asifkamal.NewEcommerce.service;

import com.asifkamal.NewEcommerce.exception.APIException;
import com.asifkamal.NewEcommerce.exception.ResourceNotFoundException;
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
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new APIException("No category exists yet");
        }
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryId(nextId++);
        Category savedCategory = categoryRepository.findCategoryByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category with categoryName of " + category.getCategoryName() + " already exists!");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        categoryRepository.delete(category);
        return "Category with ID of: " + categoryId + " deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

        optionalCategory.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryId(categoryId);
        return categoryRepository.save(category);
    }
}
