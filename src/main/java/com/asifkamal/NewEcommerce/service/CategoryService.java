package com.asifkamal.NewEcommerce.service;

import com.asifkamal.NewEcommerce.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory(Category category);

    String deleteCategory(Long categoryId);
}
