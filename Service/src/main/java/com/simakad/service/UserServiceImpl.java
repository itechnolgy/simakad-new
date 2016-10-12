package com.simakad.service;

import com.simakad.dao.entity.Users;
import com.simakad.dao.repo.UserDao;
import com.simakad.service.constant.UserType;
import com.simakad.service.constant.UsersProfileType;
import com.simakad.service.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by SRIN on 10/10/2016.
 */
@Component
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public Users createUserLogin(String username, UserType userType, Long userProfileId) {
        Users users = new Users();
        users.setUsername(username);
        users.setRoles(userType.toString());
        users.setUserProfileId(userProfileId);

        String pass = generatePassword();
        String encryptedPass = CommonUtil.passwordEncoder(pass);
        users.setPassoword(encryptedPass);
        users = userDao.save(users);

        return users;
    }

    private String generatePassword() {
        String random = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder password = new StringBuilder();
        Random r = new Random();
        while(password.length() < 7) {
            int idx = r.nextInt(random.length());
            password.append(random.charAt(idx));
        }
        return password.toString();
    }
}
