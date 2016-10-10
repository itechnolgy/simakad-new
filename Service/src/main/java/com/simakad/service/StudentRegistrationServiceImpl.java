package com.simakad.service;

import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.UserProfile;
import com.simakad.dao.repo.UserProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Objects;

/**
 * Created by HighDream on 9/25/2016.
 */
@Component
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
    private final String registrationIdSeq = "registration_id_seq";
    private final String prefixRegistration = "PMB";

    @Autowired
    UserProfileService userProfileService;

    @Autowired


    @Autowired
    EntityManager entityManager;

    @Override
    public NewStudent register(StudentRegistrationRequest studentRegistrationRequest) {
        if(!isRegistered(studentRegistrationRequest)) {
            UserProfile studentRegistrationProfile = userProfileService.createUserProfile(convertToUserProfile(studentRegistrationRequest));
//            studentRegistrationProfile.setId(createRegistrationNumber());
            userProfileDao.save(studentRegistrationProfile);
            return studentRegistrationProfile;
        }
        return null;

    }

    private boolean isRegistered(StudentRegistrationRequest studentRegistrationRequest){
        UserProfile profile = userProfileService.isUserProfileExist(studentRegistrationRequest.getEmail(), studentRegistrationRequest.getIdentityCardNumber());
        if(Objects.isNull(profile)) return false;
        else return true;
    }

    private UserProfile createStudent(StudentRegistrationRequest studentRegistrationRequest) {
        UserProfile student = new UserProfile();
        student.setName(studentRegistrationRequest.getName());
        student.setEmail(studentRegistrationRequest.getEmail());
        student.setAddress(studentRegistrationRequest.getAddress());
        student.setGender(studentRegistrationRequest.getGender());
        student.setIdentityCardNumber(studentRegistrationRequest.getIdentityCardNumber());
        student.setIdentityCardNumberType(studentRegistrationRequest.getIdentityCardNumberType());

        return student;
    }

    private UserProfile convertToUserProfile(StudentRegistrationRequest request) {
        UserProfile profile = new UserProfile();
        profile.setName(request.getName());
        profile.setAddress(request.getAddress());
        profile.setEmail(request.getEmail());
        profile.setAddress(request.getAddress());
        profile.setGender(request.getGender());
        profile.setIdentityCardNumber(request.getIdentityCardNumber());
        profile.setIdentityCardNumberType(request.getIdentityCardNumberType());
    }

}
