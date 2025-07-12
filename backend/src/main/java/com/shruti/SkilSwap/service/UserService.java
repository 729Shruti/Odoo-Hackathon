package com.shruti.SkilSwap.service;

import com.shruti.SkilSwap.dto.LoginRequest;
import com.shruti.SkilSwap.dto.ProfileUpdateRequest;
import com.shruti.SkilSwap.dto.RegisterRequest;
import com.shruti.SkilSwap.entities.User;
import com.shruti.SkilSwap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

    public User login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        return user; // You can also return just a message or user ID
    }

    public void updateProfile(Long userId, ProfileUpdateRequest request) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        User user = optionalUser.get();

        user.setLocation(request.getLocation());
        user.setProfilePhotoUrl(request.getProfilePhotoUrl());
        user.setPublic(request.isPublic());
        user.setAvailability(request.getAvailability());
        user.setSkillsOffered(request.getSkillsOffered());
        user.setSkillsWanted(request.getSkillsWanted());

        userRepository.save(user);
    }

}
