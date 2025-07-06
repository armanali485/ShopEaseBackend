package com.syntaxzero.shopease.service;

import com.syntaxzero.shopease.dto.CategoryDTO;
import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO dto);
    List<CategoryDTO> getAllCategories();
}
