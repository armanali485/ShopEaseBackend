package com.syntaxzero.shopease.mapper;

import com.syntaxzero.shopease.dto.UserDTO;
import com.syntaxzero.shopease.dto.UserResponseDTO;
import com.syntaxzero.shopease.model.User;

public class UserMapper {

    // Convert User entity to response DTO (excluding password)
    public static UserResponseDTO toResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole());
        dto.setEnabled(user.isEnabled());
        return dto;
    }

    // Convert UserDTO to entity (for create/update)
    public static User toEntity(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .role(dto.getRole())
                .enabled(dto.isEnabled())
                .build();
    }
}
