package com.syntaxzero.shopease.service.impl;

import com.syntaxzero.shopease.dto.CartItemDTO;
import com.syntaxzero.shopease.exception.ResourceNotFoundException;
import com.syntaxzero.shopease.mapper.CartItemMapper;
import com.syntaxzero.shopease.model.CartItem;
import com.syntaxzero.shopease.model.Product;
import com.syntaxzero.shopease.model.User;
import com.syntaxzero.shopease.repository.CartItemRepository;
import com.syntaxzero.shopease.repository.ProductRepository;
import com.syntaxzero.shopease.repository.UserRepository;
import com.syntaxzero.shopease.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public CartItemDTO addToCart(CartItemDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        CartItem cartItem = CartItemMapper.toEntity(dto, user, product);
        CartItem saved = cartItemRepository.save(cartItem);
        return CartItemMapper.toDTO(saved);
    }

    @Override
    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public List<CartItemDTO> getUserCart(Long userId) {
        return cartItemRepository.findByUserId(userId)
                .stream()
                .map(CartItemMapper::toDTO)
                .collect(Collectors.toList());
    }
}
