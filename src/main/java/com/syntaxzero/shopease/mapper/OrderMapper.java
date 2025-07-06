package com.syntaxzero.shopease.mapper;

import com.syntaxzero.shopease.dto.OrderDTO;
import com.syntaxzero.shopease.dto.OrderItemDTO;
import com.syntaxzero.shopease.model.Order;
import com.syntaxzero.shopease.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {

    public static Order toEntity(OrderDTO dto, User user) {
        return Order.builder()
                .id(dto.getId())
                .user(user)
                .status(dto.getStatus())
                .totalAmount(dto.getTotalAmount())
                .shippingAddress(dto.getShippingAddress())
                .paymentMethod(dto.getPaymentMethod())
                .build();
    }

    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUser().getId());
        dto.setStatus(order.getStatus());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setShippingAddress(order.getShippingAddress());
        dto.setPaymentMethod(order.getPaymentMethod());

        // Convert order items to DTOs
        List<OrderItemDTO> itemDTOs = order.getItems()
                .stream()
                .map(OrderItemMapper::toDTO)
                .collect(Collectors.toList());
        dto.setItems(itemDTOs);

        return dto;
    }
}
