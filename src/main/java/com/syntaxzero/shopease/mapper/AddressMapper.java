package com.syntaxzero.shopease.mapper;

import com.syntaxzero.shopease.dto.AddressDTO;
import com.syntaxzero.shopease.model.Address;
import com.syntaxzero.shopease.model.User;



public class AddressMapper {

    public static Address toEntity(AddressDTO dto, User user) {
        return Address.builder()
                .id(dto.getId())
                .user(user)
                .fullName(dto.getFullName())
                .street(dto.getStreet())
                .city(dto.getCity())
                .state(dto.getState())
                .postalCode(dto.getPostalCode())
                .country(dto.getCountry())
                .phone(dto.getPhone())
                .build();
    }

    public static AddressDTO toDTO(Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setUserId(address.getUser().getId());
        dto.setFullName(address.getFullName());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setPostalCode(address.getPostalCode());
        dto.setCountry(address.getCountry());
        dto.setPhone(address.getPhone());
        return dto;
    }
}
