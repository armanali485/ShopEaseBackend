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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {

    // Unique ID for each cart item
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    // Product associated with the cart item (Required)
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // User who added this cart item (Required)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Quantity of the product in the cart (Minimum 1)
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // Total price for this item (price × quantity)
    @NotNull(message = "Total price is required")
    @DecimalMin(value = "0.0", message = "Total price must be zero or positive")
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
}
