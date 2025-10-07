package com.service;

import org.springframework.stereotype.Service;

import com.entity.Users;
import com.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserNameById(Long id) {
        return userRepository.findById(id)
                .map(Users::getName)
                .orElse("Unknown");
    }
}
