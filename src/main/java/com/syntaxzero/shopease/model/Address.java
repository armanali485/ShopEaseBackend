package com.syntaxzero.shopease.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    // Unique ID for the address
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    // Many-to-one relationship with User (who this address belongs to)
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Recipient's full name (Required)
    @NotBlank(message = "Full name is required")
    @Size(max = 100, message = "Full name cannot exceed 100 characters")
    @Column(name = "full_name", nullable = false)
    private String fullName;

    // Street address (Required)
    @NotBlank(message = "Street is required")
    @Size(max = 150, message = "Street address cannot exceed 150 characters")
    @Column(name = "street", nullable = false)
    private String street;

    // City name (Required)
    @NotBlank(message = "City is required")
    @Size(max = 100, message = "City name cannot exceed 100 characters")
    @Column(name = "city", nullable = false)
    private String city;

    // State name (Required)
    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State name cannot exceed 100 characters")
    @Column(name = "state", nullable = false)
    private String state;

    // Postal/ZIP code (Required)
    @NotBlank(message = "Postal code is required")
    @Size(max = 20, message = "Postal code cannot exceed 20 characters")
    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    // Country name (Required)
    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country name cannot exceed 100 characters")
    @Column(name = "country", nullable = false)
    private String country;

    // Recipient phone number (10-digit only, Required)
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    @Column(name = "phone", nullable = false)
    private String phone;
}
