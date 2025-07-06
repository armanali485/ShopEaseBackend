package com.syntaxzero.shopease.mapper;

import com.syntaxzero.shopease.dto.PaymentDTO;
import com.syntaxzero.shopease.model.Order;
import com.syntaxzero.shopease.model.Payment;

public class PaymentMapper {

    public static Payment toEntity(PaymentDTO dto, Order order) {
        return Payment.builder()
                .id(dto.getId())
                .order(order)
                .paymentStatus(dto.getPaymentStatus())
                .transactionId(dto.getTransactionId())
                .build();
    }

    public static PaymentDTO toDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setOrderId(payment.getOrder().getId());
        dto.setPaymentStatus(payment.getPaymentStatus());
        dto.setTransactionId(payment.getTransactionId());
        return dto;
    }
}
