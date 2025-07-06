package com.syntaxzero.shopease.service.impl;

import com.syntaxzero.shopease.dto.CategoryDTO;
import com.syntaxzero.shopease.mapper.CategoryMapper;
import com.syntaxzero.shopease.model.Category;
import com.syntaxzero.shopease.repository.CategoryRepository;
import com.syntaxzero.shopease.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category saved = categoryRepository.save(CategoryMapper.toEntity(dto));
        return CategoryMapper.toDTO(saved);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
