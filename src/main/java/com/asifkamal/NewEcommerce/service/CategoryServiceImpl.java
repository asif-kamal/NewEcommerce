package com.asifkamal.NewEcommerce.service;

import com.asifkamal.NewEcommerce.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }
}
