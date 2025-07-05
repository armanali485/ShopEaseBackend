package com.syntaxzero.shopease.model;

import com.syntaxzero.shopease.enums.OrderStatus;
import com.syntaxzero.shopease.enums.PaymentMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    // Unique order ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    // Customer who placed the order
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Date and time when the order was placed
    @Column(name = "order_date")
    private LocalDateTime orderDate = LocalDateTime.now();

    // Order status (e.g., PENDING, SHIPPED, DELIVERED)
    @Column(name = "status",nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;



    // Total amount of the order (Required)
    @DecimalMin(value = "0.0", message = "Total amount must be positive")
    @Column(name = "total_amount")
    private Double totalAmount;

    // Shipping address as a plain string (could also link to Address entity)
    @Column(name = "shipping_address")
    private String shippingAddress;

    // Payment method (e.g., CARD, COD, UPI)
    @Column(name = "payment_method",nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    // List of order items (1 order → many order items)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;
}
