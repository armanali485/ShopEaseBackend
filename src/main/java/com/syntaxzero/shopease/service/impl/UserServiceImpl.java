package com.syntaxzero.shopease.service.impl;

import com.syntaxzero.shopease.dto.UserDTO;
import com.syntaxzero.shopease.dto.UserResponseDTO;
import com.syntaxzero.shopease.exception.ResourceNotFoundException;
import com.syntaxzero.shopease.exception.UserAlreadyExistsException;
import com.syntaxzero.shopease.mapper.UserMapper;
import com.syntaxzero.shopease.model.User;
import com.syntaxzero.shopease.repository.UserRepository;
import com.syntaxzero.shopease.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserAlreadyExistsException("A user with this email already exists.");
        }

        //Phone number check
         if (userRepository.existsByPhone(dto.getPhone())) {
             throw new UserAlreadyExistsException("Phone number is already in use.");
         }

        User user = UserMapper.toEntity(dto);
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());

        User savedUser = userRepository.save(user);
        return UserMapper.toResponseDTO(savedUser);
    }


    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return UserMapper.toResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
