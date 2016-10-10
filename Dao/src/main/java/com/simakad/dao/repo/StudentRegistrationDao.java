package com.simakad.dao.repo;

import com.simakad.dao.entity.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HighDream on 9/25/2016.
 */
public interface StudentRegistrationDao extends JpaRepository<StudentRegistration, String> {
    StudentRegistration findByEmail(String email);
    StudentRegistration findByIdentityCardNumber(String cardNumber);
}
