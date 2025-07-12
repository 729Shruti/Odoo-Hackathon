package com.shruti.SkilSwap.controller;

import com.shruti.SkilSwap.dto.UserProfileDto;
import com.shruti.SkilSwap.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {


    @Autowired
    private UserProfileService userProfileService;

    @GetMapping
    public List<UserProfileDto> getAllProfiles() {
        return userProfileService.getAllPublicProfiles();
    }
}
