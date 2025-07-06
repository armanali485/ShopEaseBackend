package com.syntaxzero.shopease.service.impl;

import com.syntaxzero.shopease.dto.OrderDTO;
import com.syntaxzero.shopease.dto.OrderItemDTO;
import com.syntaxzero.shopease.exception.ResourceNotFoundException;
import com.syntaxzero.shopease.mapper.OrderItemMapper;
import com.syntaxzero.shopease.mapper.OrderMapper;
import com.syntaxzero.shopease.model.*;
import com.syntaxzero.shopease.repository.*;
import com.syntaxzero.shopease.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public OrderDTO placeOrder(OrderDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Order order = OrderMapper.toEntity(dto, user);

        List<OrderItem> items = dto.getItems().stream().map(itemDTO -> {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            return OrderItemMapper.toEntity(itemDTO, order, product);
        }).collect(Collectors.toList());

        order.setItems(items);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toDTO(savedOrder);
    }

    @Override
    public List<OrderDTO> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }
}
