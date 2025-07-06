package com.syntaxzero.shopease.service;

import com.syntaxzero.shopease.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO makePayment(PaymentDTO dto);
}
