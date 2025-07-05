package com.syntaxzero.shopease.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartItemDTO {

    private Long id;

    @NotNull
    private Long productId;

    @NotNull
    private Long userId;

    @Min(1)
    private Integer quantity;

    @DecimalMin("0.0")
    private Double totalPrice;
}
