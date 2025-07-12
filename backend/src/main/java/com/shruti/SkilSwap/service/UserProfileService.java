package com.shruti.SkilSwap.service;

import com.shruti.SkilSwap.dto.UserProfileDto;
import com.shruti.SkilSwap.entities.User;
import com.shruti.SkilSwap.repository.UserProfileRepository;
import com.shruti.SkilSwap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userRepository;

    public List<UserProfileDto> getAllPublicProfiles() {


        List<User> users = userRepository.findAll(); // 🔁 ignore filtering
        List<UserProfileDto> dtoList = new ArrayList<>();

        for (User user : users) {
            // no check for isPublic/isBanned
            UserProfileDto dto = new UserProfileDto(
                    user.getId(),
                    user.getName(),
                    user.getSkillsOffered(),
                    user.getSkillsWanted(),
                    user.getProfilePhotoUrl(),
                    user.getAvailability()
            );
            dtoList.add(dto);
        }

        return dtoList;

//        List<User> users = userRepository.findByIsPublicTrueAndIsBannedFalse();
//        List<UserProfileDto> dtoList = new ArrayList<>();
//
//        for (User user : users) {
//            UserProfileDto dto = new UserProfileDto(
//                    user.getId(),
//                    user.getName(),
//                    user.getSkillsOffered(),
//                    user.getSkillsWanted(),
//                    user.getProfilePhotoUrl(),
//                    user.getAvailability()
//            );
//            dtoList.add(dto);
//        }
//
//        return dtoList;
    }
}

