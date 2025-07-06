package com.syntaxzero.shopease.service;

import com.syntaxzero.shopease.dto.CartItemDTO;
import java.util.List;

public interface CartService {
    CartItemDTO addToCart(CartItemDTO dto);
    void removeFromCart(Long cartItemId);
    List<CartItemDTO> getUserCart(Long userId);
}
