package com.syntaxzero.shopease.service;

import com.syntaxzero.shopease.dto.AddressDTO;
import java.util.List;

public interface AddressService {
    AddressDTO addAddress(AddressDTO dto);
    List<AddressDTO> getUserAddresses(Long userId);
}
