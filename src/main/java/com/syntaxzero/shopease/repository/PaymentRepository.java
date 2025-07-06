package com.syntaxzero.shopease.repository;

import com.syntaxzero.shopease.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
