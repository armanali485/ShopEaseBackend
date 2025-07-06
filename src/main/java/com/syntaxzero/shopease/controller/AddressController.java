package com.syntaxzero.shopease.controller;

import com.syntaxzero.shopease.dto.AddressDTO;
import com.syntaxzero.shopease.payload.ApiResponse;
import com.syntaxzero.shopease.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<ApiResponse<AddressDTO>> add(@Valid @RequestBody AddressDTO dto) {
        return ResponseEntity.ok(
                ApiResponse.<AddressDTO>builder()
                        .success(true)
                        .message("Address added successfully")
                        .data(addressService.addAddress(dto))
                        .build()
        );
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<ApiResponse<List<AddressDTO>>> forUser(@PathVariable("uid") Long userId) {
        return ResponseEntity.ok(
                ApiResponse.<List<AddressDTO>>builder()
                        .success(true)
                        .message("User addresses fetched")
                        .data(addressService.getUserAddresses(userId))
                        .build()
        );
    }
}

