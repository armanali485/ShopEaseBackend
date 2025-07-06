package com.syntaxzero.shopease.mapper;

import com.syntaxzero.shopease.dto.ReviewDTO;
import com.syntaxzero.shopease.model.Product;
import com.syntaxzero.shopease.model.Review;
import com.syntaxzero.shopease.model.User;

public class ReviewMapper {

    public static Review toEntity(ReviewDTO dto, User user, Product product) {
        return Review.builder()
                .id(dto.getId())
                .user(user)
                .product(product)
                .rating(dto.getRating())
                .comment(dto.getComment())
                .build();
    }

    public static ReviewDTO toDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setUserId(review.getUser().getId());
        dto.setProductId(review.getProduct().getId());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        return dto;
    }
}
