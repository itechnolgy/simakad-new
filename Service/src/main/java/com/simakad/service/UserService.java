package com.simakad.service;

import com.simakad.dao.constant.UserType;
import com.simakad.dao.entity.UserProfile;
import com.simakad.dao.entity.Users;
import org.springframework.security.core.userdetails.User;

/**
 * Created by SRIN on 10/10/2016.
 */
public interface UserService {
    Users createUserLogin(String username, UserType userType, Long userProfileId, String email);
    Users forgotPassword(String email);

    UserProfile getUserProfile(String username);
}
