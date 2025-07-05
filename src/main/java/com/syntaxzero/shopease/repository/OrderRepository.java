package com.syntaxzero.shopease.repository;

import com.syntaxzero.shopease.model.Order;
import com.syntaxzero.shopease.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
