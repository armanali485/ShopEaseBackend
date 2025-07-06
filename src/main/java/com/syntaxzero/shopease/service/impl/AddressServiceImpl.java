package com.syntaxzero.shopease.service.impl;

import com.syntaxzero.shopease.dto.AddressDTO;
import com.syntaxzero.shopease.exception.ResourceNotFoundException;
import com.syntaxzero.shopease.mapper.AddressMapper;
import com.syntaxzero.shopease.model.Address;
import com.syntaxzero.shopease.model.User;
import com.syntaxzero.shopease.repository.AddressRepository;
import com.syntaxzero.shopease.repository.UserRepository;
import com.syntaxzero.shopease.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Override
    public AddressDTO addAddress(AddressDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Address saved = addressRepository.save(AddressMapper.toEntity(dto, user));
        return AddressMapper.toDTO(saved);
    }

    @Override
    public List<AddressDTO> getUserAddresses(Long userId) {
        return addressRepository.findByUserId(userId).stream()
                .map(AddressMapper::toDTO)
                .collect(Collectors.toList());
    }
}
