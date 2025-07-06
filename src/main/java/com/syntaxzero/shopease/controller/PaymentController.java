package com.syntaxzero.shopease.controller;

import com.syntaxzero.shopease.dto.PaymentDTO;
import com.syntaxzero.shopease.payload.ApiResponse;
import com.syntaxzero.shopease.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<ApiResponse<PaymentDTO>> pay(@Valid @RequestBody PaymentDTO dto) {
        return ResponseEntity.ok(
                ApiResponse.<PaymentDTO>builder()
                        .success(true)
                        .message("Payment processed successfully")
                        .data(paymentService.makePayment(dto))
                        .build()
        );
    }
}

