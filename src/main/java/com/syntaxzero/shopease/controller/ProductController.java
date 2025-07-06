package com.syntaxzero.shopease.controller;

import com.syntaxzero.shopease.dto.ProductDTO;
import com.syntaxzero.shopease.payload.ApiResponse;
import com.syntaxzero.shopease.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> create(@Valid @RequestBody ProductDTO dto) {
        ProductDTO created = productService.createProduct(dto);
        return ResponseEntity.ok(
                ApiResponse.<ProductDTO>builder()
                        .success(true)
                        .message("Product created successfully")
                        .data(created)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAll() {
        return ResponseEntity.ok(
                ApiResponse.<List<ProductDTO>>builder()
                        .success(true)
                        .message("All products fetched")
                        .data(productService.getAllProducts())
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                ApiResponse.<ProductDTO>builder()
                        .success(true)
                        .message("Product fetched")
                        .data(productService.getProductById(id))
                        .build()
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDTO>> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(
                ApiResponse.<ProductDTO>builder()
                        .success(true)
                        .message("Product updated")
                        .data(productService.updateProduct(id, dto))
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("Product deleted")
                        .data(null)
                        .build()
        );
    }

    @GetMapping("/category/{cid}")
    public ResponseEntity<ApiResponse<List<ProductDTO>>> byCategory(@PathVariable("cid") Long categoryId) {
        return ResponseEntity.ok(
                ApiResponse.<List<ProductDTO>>builder()
                        .success(true)
                        .message("Products by category")
                        .data(productService.getProductsByCategory(categoryId))
                        .build()
        );
    }
}

