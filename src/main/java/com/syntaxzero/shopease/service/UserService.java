package com.syntaxzero.shopease.service;

import com.syntaxzero.shopease.dto.UserDTO;
import com.syntaxzero.shopease.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserDTO userDTO);
    UserResponseDTO getUserById(Long userId);
    List<UserResponseDTO> getAllUsers();
    void deleteUser(Long userId);
}
