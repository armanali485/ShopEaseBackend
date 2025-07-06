package com.syntaxzero.shopease.service.impl;

import com.syntaxzero.shopease.dto.PaymentDTO;
import com.syntaxzero.shopease.exception.ResourceNotFoundException;
import com.syntaxzero.shopease.mapper.PaymentMapper;
import com.syntaxzero.shopease.model.Order;
import com.syntaxzero.shopease.model.Payment;
import com.syntaxzero.shopease.repository.OrderRepository;
import com.syntaxzero.shopease.repository.PaymentRepository;
import com.syntaxzero.shopease.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    @Override
    public PaymentDTO makePayment(PaymentDTO dto) {
        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        Payment payment = PaymentMapper.toEntity(dto, order);
        Payment saved = paymentRepository.save(payment);
        return PaymentMapper.toDTO(saved);
    }
}
