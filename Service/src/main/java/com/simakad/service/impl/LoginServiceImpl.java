package com.simakad.service.impl;


import com.simakad.dao.repo.NewStudentDao;
import com.simakad.dao.repo.StudentDao;
import com.simakad.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by SRIN on 9/20/2016.
 */
@Component
public class LoginServiceImpl implements LoginService {
    final String prefixNewStudent = "PMB";

//    @Autowired
//    StudentDao studentDao;
//
//    @Autowired
//    NewStudentDao newStudentDao;

    @Override
    public void login(String username, String password) {
        if(isNewStudent(username)) {
//            newStudentDao.findOne(username);
        } else {
//            studentDao.findOne(username);
        }
    }

    @Override
    public void logout() {

    }

    private boolean isNewStudent(String username) {
        if(username.substring(3).equals(prefixNewStudent)) return true;
        else return false;
    }
}
