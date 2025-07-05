
package com.syntaxzero.shopease.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.syntaxzero.shopease.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    // Primary key: auto-incremented user ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    // Full name of the user (Required, 2-100 characters)
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(name = "full_name", nullable = false)
    private String name;

    // Unique email used for login (Required, valid email format)
    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    // User's login password (Required, minimum 6 characters)
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Column(name = "password", nullable = false)
    private String password;

    // Optional mobile number (10 digits only)
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    @Column(name = "phone")
    private String phone;

    // Role of the user (e.g., ADMIN, CUSTOMER) - Required
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    // Account status (enabled or disabled)
    @Column(name = "enabled")
    private boolean enabled = true;

    // Date and time when the user was created
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // List of addresses associated with the user (ignored in JSON to avoid recursion)
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Address> addresses;
}
