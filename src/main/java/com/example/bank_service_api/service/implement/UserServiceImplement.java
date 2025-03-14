package com.example.bank_service_api.service.implement;

import com.example.bank_service_api.exception.ResourceNotFoundException;
import com.example.bank_service_api.model.User;
import com.example.bank_service_api.repository.UserRepository;
import com.example.bank_service_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found")
        );
    }
}
