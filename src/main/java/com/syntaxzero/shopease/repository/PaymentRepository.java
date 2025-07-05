package com.syntaxzero.shopease.repository;

import com.syntaxzero.shopease.model.Order;
import com.syntaxzero.shopease.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByOrder(Order order);
}
