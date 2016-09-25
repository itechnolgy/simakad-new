package com.simakad.service;

import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.entity.StudentRegistration;
import com.simakad.dao.repo.StudentRegistrationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by HighDream on 9/25/2016.
 */
@Component
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
    @Autowired
    StudentRegistrationDao studentRegistrationDao;

    @Override
    public StudentRegistration register(StudentRegistrationRequest studentRegistrationRequest) {
        if(!isRegistered(studentRegistrationRequest)) {
            StudentRegistration studentRegistration = createStudent(studentRegistrationRequest);
            studentRegistrationDao.save(studentRegistration);
            return studentRegistration;
        }
        return null;
    }

    private boolean isRegistered(StudentRegistrationRequest studentRegistrationRequest){
        StudentRegistration student = studentRegistrationDao.findByEmail(studentRegistrationRequest.getEmail());
        if(Objects.isNull(student)) {
            student = studentRegistrationDao.findByIdentityCardNumber(studentRegistrationRequest.getIdentityCardNumber());
            if(Objects.isNull(student)) return false;
        }
        return true;
    }

    private StudentRegistration createStudent(StudentRegistrationRequest studentRegistrationRequest) {
        StudentRegistration student = new StudentRegistration();
        student.setName(studentRegistrationRequest.getName());
        student.setEmail(studentRegistrationRequest.getEmail());
        student.setAddress(studentRegistrationRequest.getAddress());
        student.setGender(studentRegistrationRequest.getGender());
        student.setIdentityCardNumber(studentRegistrationRequest.getIdentityCardNumber());
        student.setIdentityCardNumberType(studentRegistrationRequest.getIdentityCardNumberType());

        return student;
    }
}
