package com.shruti.SkilSwap.repository;

import com.shruti.SkilSwap.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<User, Long> {
    List<User> findByIsPublicTrueAndIsBannedFalse();
}

