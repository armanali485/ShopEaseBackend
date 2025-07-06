package com.syntaxzero.shopease.repository;

import com.syntaxzero.shopease.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
