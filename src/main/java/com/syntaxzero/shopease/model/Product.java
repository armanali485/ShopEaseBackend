package com.syntaxzero.shopease.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    // Primary key for product
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    // Product name (Required)
    @NotBlank(message = "Product name is required")
    @Column(name = "product_name", nullable = false)
    private String name;

    // Product description (Required, max 500 characters)
    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(name = "description")
    private String description;

    // Product price (Required, must be >= 0.0)
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", message = "Price must be greater than or equal to 0")
    @Column(name = "price", nullable = false)
    private Double price;

    // Available stock quantity (Required, must be >= 0)
    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock must be zero or positive")
    @Column(name = "stock", nullable = false)
    private Integer stock;

    // Optional image URL for the product
    @Column(name = "image_url")
    private String imageUrl;

    // Linked category for the product
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Timestamp when product was added
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Product availability status
    @Column(name = "is_active")
    private boolean isActive = true;
}
