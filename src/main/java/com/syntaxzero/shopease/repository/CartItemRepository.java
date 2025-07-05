package com.syntaxzero.shopease.repository;

import com.syntaxzero.shopease.model.CartItem;
import com.syntaxzero.shopease.model.Product;
import com.syntaxzero.shopease.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
    Optional<CartItem> findByUserAndProduct(User user, Product product);
    void deleteByUser(User user);
}
