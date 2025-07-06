package com.syntaxzero.shopease.service;

import com.syntaxzero.shopease.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO placeOrder(OrderDTO dto);
    List<OrderDTO> getOrdersByUser(Long userId);
}
