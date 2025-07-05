package com.syntaxzero.shopease.repository;

import com.syntaxzero.shopease.model.Address;
import com.syntaxzero.shopease.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByUser(User user);
}
