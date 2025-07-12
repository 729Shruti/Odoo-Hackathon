package com.shruti.SkilSwap.controller;

import com.shruti.SkilSwap.dto.ProfileUpdateRequest;
import com.shruti.SkilSwap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://127.0.0.1:5500",allowCredentials = "true")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PutMapping("/{name}/complete-profile")

    public ResponseEntity<String> completeProfile(
                                                  @RequestBody ProfileUpdateRequest request) {
         Long userId=1L;
        userService.updateProfile(userId, request);
        return ResponseEntity.ok("Profile updated successfully");
    }
}
