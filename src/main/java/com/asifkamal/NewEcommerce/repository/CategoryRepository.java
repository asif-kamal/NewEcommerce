package com.asifkamal.NewEcommerce.repository;

import com.asifkamal.NewEcommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
