package com.syntaxzero.shopease.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    // Unique review ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    // Reviewed product
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Reviewer (user who wrote the review)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Rating out of 5
    @Min(value = 1, message = "Minimum rating is 1")
    @Max(value = 5, message = "Maximum rating is 5")
    @Column(name = "rating")
    private Integer rating;

    // Optional comment (max 500 characters)
    @Size(max = 500, message = "Comment cannot exceed 500 characters")
    @Column(name = "comment")
    private String comment;

    // Time of review
    @Column(name = "review_date")
    private LocalDateTime reviewDate = LocalDateTime.now();
}
