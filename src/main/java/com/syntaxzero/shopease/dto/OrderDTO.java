package com.syntaxzero.shopease.dto;

import com.syntaxzero.shopease.enums.OrderStatus;
import com.syntaxzero.shopease.enums.PaymentMethod;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    @NotNull
    private Long userId;

    private OrderStatus status;

    @DecimalMin("0.0")
    private Double totalAmount;

    private String shippingAddress;

    private PaymentMethod paymentMethod;

    private List<OrderItemDTO> items;
}
