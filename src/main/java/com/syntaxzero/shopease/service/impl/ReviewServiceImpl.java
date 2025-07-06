package com.syntaxzero.shopease.service.impl;

import com.syntaxzero.shopease.dto.ReviewDTO;
import com.syntaxzero.shopease.exception.ResourceNotFoundException;
import com.syntaxzero.shopease.mapper.ReviewMapper;
import com.syntaxzero.shopease.model.Product;
import com.syntaxzero.shopease.model.Review;
import com.syntaxzero.shopease.model.User;
import com.syntaxzero.shopease.repository.ProductRepository;
import com.syntaxzero.shopease.repository.ReviewRepository;
import com.syntaxzero.shopease.repository.UserRepository;
import com.syntaxzero.shopease.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public ReviewDTO submitReview(ReviewDTO dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Review saved = reviewRepository.save(ReviewMapper.toEntity(dto, user, product));
        return ReviewMapper.toDTO(saved);
    }

    @Override
    public List<ReviewDTO> getProductReviews(Long productId) {
        return reviewRepository.findByProductId(productId).stream()
                .map(ReviewMapper::toDTO)
                .collect(Collectors.toList());
    }
}
