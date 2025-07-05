package com.syntaxzero.shopease.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ReviewDTO {

    private Long id;

    private Long productId;

    private Long userId;

    @Min(1)
    @Max(5)
    private Integer rating;

    @Size(max = 500)
    private String comment;
}
