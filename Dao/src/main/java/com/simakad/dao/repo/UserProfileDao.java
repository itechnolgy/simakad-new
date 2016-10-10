package com.simakad.dao.repo;

import com.simakad.dao.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HighDream on 9/25/2016.
 */
public interface UserProfileDao extends JpaRepository<UserProfile, String> {
    UserProfile findByEmail(String email);
    UserProfile findByIdentityCardNumber(String cardNumber);
}
