package com.simakad.service;

import com.simakad.dao.constant.EmailType;
import com.simakad.dao.constant.StudentStatusType;
import com.simakad.dao.constant.UserType;
import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.Student;
import com.simakad.dao.entity.UserProfile;
import com.simakad.dao.entity.Users;
import com.simakad.dao.repo.NewStudentDao;
import com.simakad.dao.repo.UserProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Objects;

/**
 * Created by HighDream on 9/25/2016.
 */
@Component
@Transactional
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
    private final String registrationIdSeq = "seq_student_registration";
    private final String prefixRegistration = "PMB";

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    RegPaymentService regPaymentService;

    @Autowired
    RegExamService regExamService;

    @Autowired
    EmailService emailService;

    @Autowired
    UserService userService;

    @Autowired
    NewStudentDao newStudentDao;

    @Autowired
    EntityManager entityManager;


    @Override
    @Transactional
    public NewStudent register(StudentRegistrationRequest studentRegistrationRequest) {
        if(!isRegistered(studentRegistrationRequest)) {
            UserProfile studentRegistrationProfile = userProfileService.createUserProfile(convertToUserProfile(studentRegistrationRequest));
            NewStudent newStudent = createNewStudent(studentRegistrationRequest.getDegreeId());
            Users login = userService.createUserLogin(newStudent.getId(), UserType.NEW_STUDENT, studentRegistrationProfile.getId(), studentRegistrationProfile.getEmail());
            regExamService.putDefaultExamResult(newStudent.getId());
            emailService.sendMessage(EmailType.REGISTRATION,  UserType.NEW_STUDENT, studentRegistrationProfile.getEmail(), login);
            return newStudent;
        }
        return null;

    }

    @Override
    public NewStudent findNewStudent(String id) {
        return newStudentDao.findOne(id);
    }

    private boolean isRegistered(StudentRegistrationRequest studentRegistrationRequest){
        UserProfile profile = userProfileService.isUserProfileExist(studentRegistrationRequest.getEmail(), studentRegistrationRequest.getIdentityCardNumber());
        if(Objects.isNull(profile)) return false;
        else return true;
    }

    private NewStudent createNewStudent(Long degreeId) {
        NewStudent newStudent = new NewStudent();
        newStudent.setId(createRegistrationNumber());
        newStudent.setDegreeId(degreeId);
        newStudent.setStatus(StudentStatusType.ACTIVE.toString());
        newStudent = newStudentDao.save(newStudent);
        return  newStudent;
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
        return profile;
    }

    private String createRegistrationNumber() {
        String regNumber = prefixRegistration + getIncrementId();
        return regNumber;
    }

    private Long getIncrementId() {
        Query q = entityManager.createNativeQuery("select nextval('"+ registrationIdSeq +"')");
        return (Long) q.getSingleResult();
    }
}
