package com.simakad.service;

import com.simakad.dao.entity.UserProfile;

/**
 * Created by SRIN on 10/10/2016.
 */
public interface UserProfileService {
    UserProfile createUserProfile(UserProfile userProfile);
    UserProfile isUserProfileExist(String email, String identityNumber);

}
