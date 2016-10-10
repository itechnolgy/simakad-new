package com.simakad.service;

import com.simakad.dao.entity.UserProfile;
import com.simakad.dao.repo.UserProfileDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * Created by SRIN on 10/10/2016.
 */
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    UserProfileDao userProfileDao;

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {

    }

    @Override
    public UserProfile isUserProfileExist(String email, String identityNumber) {
        UserProfile userProfile = userProfileDao.findByEmail(email);
        if(Objects.isNull(userProfile)) {
            userProfile = userProfileDao.findByIdentityCardNumber(identityNumber);
        }
        return userProfile;
    }

}
