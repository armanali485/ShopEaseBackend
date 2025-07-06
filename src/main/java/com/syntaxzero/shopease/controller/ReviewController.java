package com.syntaxzero.shopease.controller;

import com.syntaxzero.shopease.dto.ReviewDTO;
import com.syntaxzero.shopease.payload.ApiResponse;
import com.syntaxzero.shopease.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ApiResponse<ReviewDTO>> submit(@Valid @RequestBody ReviewDTO dto) {
        return ResponseEntity.ok(
                ApiResponse.<ReviewDTO>builder()
                        .success(true)
                        .message("Review submitted successfully")
                        .data(reviewService.submitReview(dto))
                        .build()
        );
    }

    @GetMapping("/product/{pid}")
    public ResponseEntity<ApiResponse<List<ReviewDTO>>> forProduct(@PathVariable("pid") Long productId) {
        return ResponseEntity.ok(
                ApiResponse.<List<ReviewDTO>>builder()
                        .success(true)
                        .message("Reviews for product fetched")
                        .data(reviewService.getProductReviews(productId))
                        .build()
        );
    }
}
