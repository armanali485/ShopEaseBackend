package com.syntaxzero.shopease.repository;

import com.syntaxzero.shopease.model.Order;
import com.syntaxzero.shopease.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder(Order order);
}
