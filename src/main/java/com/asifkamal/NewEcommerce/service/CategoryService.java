package com.asifkamal.NewEcommerce.service;

import com.asifkamal.NewEcommerce.model.Category;
import com.asifkamal.NewEcommerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
