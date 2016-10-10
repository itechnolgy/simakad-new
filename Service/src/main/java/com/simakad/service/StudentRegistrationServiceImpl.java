package com.simakad.service;

import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.entity.StudentRegistration;
import com.simakad.dao.repo.StudentRegistrationDao;
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
    StudentRegistrationDao studentRegistrationDao;

    @Autowired
    EntityManager entityManager;

    @Override
    public StudentRegistration register(StudentRegistrationRequest studentRegistrationRequest) {
        if(!isRegistered(studentRegistrationRequest)) {
            StudentRegistration studentRegistration = createStudent(studentRegistrationRequest);
            studentRegistration.setId(createRegistrationNumber());
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

    private String createRegistrationNumber() {
        String regNumber = prefixRegistration + getIncrementId();
        return regNumber;
    }

    private Long getIncrementId() {
        Query q = entityManager.createNativeQuery("select nextval('"+ registrationIdSeq +"')");
        return (Long) q.getSingleResult();
    }
}
