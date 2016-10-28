package com.simakad.service;

import com.simakad.dao.constant.UserType;
import com.simakad.dao.entity.Users;
import com.simakad.dao.repo.UserDao;
import com.simakad.service.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Random;

/**
 * Created by SRIN on 10/10/2016.
 */
@Component
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Override
    public Users createUserLogin(String username, UserType userType, Long userProfileId, String email) {
        Users users = new Users();
        users.setUsername(username);
        users.setRoles(userType);
        users.setUserProfileId(userProfileId);
        users.setEmail(email);

        String pass = generatePassword();
        String encryptedPass = CommonUtil.passwordEncoder(pass);
        users.setPassoword(encryptedPass);
        users = userDao.save(users);
        users.setDecryptPass(pass);
        return users;
    }

    @Override
    public Users forgotPassword(String email) {
        Users user = userDao.findByEmail(email);
        if(!Objects.isNull(user)) {
            String pass = generatePassword();
            String encryptedPass = CommonUtil.passwordEncoder(pass);
            user.setPassoword(encryptedPass);
            user = userDao.save(user);
            user.setDecryptPass(pass);
        }
        return user;
    }

//    private Users isUsersExist(String email) {
//        Users user = userDao.findByEmail(email);
//        if(Objects.isNull(user))
//            return false;
//        else
//            return true;
//    }

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
