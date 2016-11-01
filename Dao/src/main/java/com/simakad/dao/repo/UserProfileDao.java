package com.simakad.dao.repo;

import com.simakad.dao.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SRIN on 2016-10-12.
 */
public interface UserProfileDao extends JpaRepository<UserProfile, Long> {
    UserProfile findByEmail(String email);
    UserProfile findByIdentityCardNumber(String cardNumber);
}
