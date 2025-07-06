package com.syntaxzero.shopease.controller;

import com.syntaxzero.shopease.dto.CategoryDTO;
import com.syntaxzero.shopease.payload.ApiResponse;
import com.syntaxzero.shopease.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDTO>> create(@Valid @RequestBody CategoryDTO dto) {
        return ResponseEntity.ok(
                ApiResponse.<CategoryDTO>builder()
                        .success(true)
                        .message("Category created successfully")
                        .data(categoryService.createCategory(dto))
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> list() {
        return ResponseEntity.ok(
                ApiResponse.<List<CategoryDTO>>builder()
                        .success(true)
                        .message("All categories fetched")
                        .data(categoryService.getAllCategories())
                        .build()
        );
    }
}

