package com.syntaxzero.shopease.dto;

import com.syntaxzero.shopease.enums.UserRole;
import lombok.Data;

@Data
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private UserRole role;
    private boolean enabled;
}
