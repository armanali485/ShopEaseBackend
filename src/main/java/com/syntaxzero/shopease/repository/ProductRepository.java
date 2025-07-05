package com.syntaxzero.shopease.repository;

import com.syntaxzero.shopease.model.Category;
import com.syntaxzero.shopease.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
    List<Product> findByIsActiveTrue();
}
