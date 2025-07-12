package com.shruti.SkilSwap.controller;

import com.shruti.SkilSwap.dto.ProfileUpdateRequest;
import com.shruti.SkilSwap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PutMapping("/{userId}/complete-profile")

    public ResponseEntity<String> completeProfile(
                                                  @RequestBody ProfileUpdateRequest request) {
         Long userId=1L;
        userService.updateProfile(userId, request);
        return ResponseEntity.ok("Profile updated successfully");
    }
}
