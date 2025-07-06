package com.syntaxzero.shopease.controller;

import com.syntaxzero.shopease.dto.CartItemDTO;
import com.syntaxzero.shopease.payload.ApiResponse;
import com.syntaxzero.shopease.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<ApiResponse<CartItemDTO>> add(@Valid @RequestBody CartItemDTO dto) {
        return ResponseEntity.ok(
                ApiResponse.<CartItemDTO>builder()
                        .success(true)
                        .message("Item added to cart")
                        .data(cartService.addToCart(dto))
                        .build()
        );
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<ApiResponse<List<CartItemDTO>>> view(@PathVariable("uid") Long userId) {
        return ResponseEntity.ok(
                ApiResponse.<List<CartItemDTO>>builder()
                        .success(true)
                        .message("User cart fetched")
                        .data(cartService.getUserCart(userId))
                        .build()
        );
    }

    @DeleteMapping("/{cid}")
    public ResponseEntity<ApiResponse<Void>> remove(@PathVariable("cid") Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.ok(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("Item removed from cart")
                        .data(null)
                        .build()
        );
    }
}

