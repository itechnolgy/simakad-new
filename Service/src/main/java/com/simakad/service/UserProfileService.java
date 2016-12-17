package com.simakad.service;

import com.simakad.dao.entity.UserProfile;

/**
 * Created by SRIN on 2016-10-12.
 */
public interface UserProfileService {
    public UserProfile createUserProfile(UserProfile userProfile);
    public UserProfile isUserProfileExist(String email, String identityNumber);

}
