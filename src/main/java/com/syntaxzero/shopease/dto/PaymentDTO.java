package com.syntaxzero.shopease.dto;

import com.syntaxzero.shopease.enums.PaymentStatus;
import lombok.Data;

@Data
public class PaymentDTO {

    private Long id;

    private Long orderId;

    private PaymentStatus paymentStatus;

    private String transactionId;
}
