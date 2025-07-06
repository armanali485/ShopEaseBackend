package com.syntaxzero.shopease.mapper;

import com.syntaxzero.shopease.dto.CartItemDTO;
import com.syntaxzero.shopease.model.CartItem;
import com.syntaxzero.shopease.model.Product;
import com.syntaxzero.shopease.model.User;

public class CartItemMapper {

    public static CartItem toEntity(CartItemDTO dto, User user, Product product) {
        return CartItem.builder()
                .id(dto.getId())
                .user(user)
                .product(product)
                .quantity(dto.getQuantity())
                .totalPrice(dto.getTotalPrice())
                .build();
    }

    public static CartItemDTO toDTO(CartItem cartItem) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(cartItem.getId());
        dto.setUserId(cartItem.getUser().getId());
        dto.setProductId(cartItem.getProduct().getId());
        dto.setQuantity(cartItem.getQuantity());
        dto.setTotalPrice(cartItem.getTotalPrice());
        return dto;
    }
}
