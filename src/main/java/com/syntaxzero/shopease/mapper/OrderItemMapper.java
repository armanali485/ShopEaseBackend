package com.syntaxzero.shopease.mapper;

import com.syntaxzero.shopease.dto.OrderItemDTO;
import com.syntaxzero.shopease.model.Order;
import com.syntaxzero.shopease.model.OrderItem;
import com.syntaxzero.shopease.model.Product;

public class OrderItemMapper {

    public static OrderItem toEntity(OrderItemDTO dto, Order order, Product product) {
        return OrderItem.builder()
                .id(dto.getId())
                .order(order)
                .product(product)
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();
    }

    public static OrderItemDTO toDTO(OrderItem orderItem) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setId(orderItem.getId());
        dto.setProductId(orderItem.getProduct().getId());
        dto.setQuantity(orderItem.getQuantity());
        dto.setPrice(orderItem.getPrice());
        return dto;
    }
}
