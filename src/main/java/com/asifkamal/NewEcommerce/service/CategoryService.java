package com.asifkamal.NewEcommerce.service;

import com.asifkamal.NewEcommerce.model.Category;
import com.asifkamal.NewEcommerce.payload.CategoryDTO;
import com.asifkamal.NewEcommerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
