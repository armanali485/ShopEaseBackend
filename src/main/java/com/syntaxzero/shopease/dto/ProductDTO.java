package com.syntaxzero.shopease.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Product name is required")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description can't exceed 500 characters")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin("0.0")
    private Double price;

    @NotNull(message = "Stock is required")
    @Min(0)
    private Integer stock;

    private String imageUrl;

    private Long categoryId;
}
