package com.syntaxzero.shopease.controller;

import com.syntaxzero.shopease.dto.OrderDTO;
import com.syntaxzero.shopease.payload.ApiResponse;
import com.syntaxzero.shopease.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderDTO>> place(@Valid @RequestBody OrderDTO dto) {
        return ResponseEntity.ok(
                ApiResponse.<OrderDTO>builder()
                        .success(true)
                        .message("Order placed successfully")
                        .data(orderService.placeOrder(dto))
                        .build()
        );
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<ApiResponse<List<OrderDTO>>> byUser(@PathVariable("uid") Long userId) {
        return ResponseEntity.ok(
                ApiResponse.<List<OrderDTO>>builder()
                        .success(true)
                        .message("User orders fetched")
                        .data(orderService.getOrdersByUser(userId))
                        .build()
        );
    }
}
