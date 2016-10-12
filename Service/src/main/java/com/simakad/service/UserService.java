package com.simakad.service;

import com.simakad.dao.entity.Users;
import com.simakad.service.constant.UserType;

/**
 * Created by SRIN on 10/10/2016.
 */
public interface UserService {
    Users createUserLogin(String username, UserType userType, Long userProfileId);
}
