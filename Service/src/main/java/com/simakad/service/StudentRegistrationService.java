package com.simakad.service;

import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.entity.StudentRegistration;

/**
 * Created by HighDream on 9/25/2016.
 */
public interface StudentRegistrationService {
    StudentRegistration register(StudentRegistrationRequest studentRegistrationRequest);
}
