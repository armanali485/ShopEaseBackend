package com.syntaxzero.shopease.model;

import com.syntaxzero.shopease.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    // Unique payment ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    // One-to-one link with the order
    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Payment status (e.g., SUCCESS, FAILED)

    @Column(name = "payment_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    // Transaction reference ID from gateway
    @Column(name = "transaction_id")
    private String transactionId;

    // Payment time stamp
    @Column(name = "payment_date")
    private LocalDateTime paymentDate = LocalDateTime.now();
}
