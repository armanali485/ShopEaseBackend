package com.syntaxzero.shopease.repository;

import com.syntaxzero.shopease.model.Product;
import com.syntaxzero.shopease.model.Review;
import com.syntaxzero.shopease.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct(Product product);
    Optional<Review> findByProductAndUser(Product product, User user);
}
