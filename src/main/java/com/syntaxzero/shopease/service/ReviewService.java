package com.syntaxzero.shopease.service;

import com.syntaxzero.shopease.dto.ReviewDTO;
import java.util.List;

public interface ReviewService {
    ReviewDTO submitReview(ReviewDTO dto);
    List<ReviewDTO> getProductReviews(Long productId);
}

