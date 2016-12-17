package com.simakad.service.registration;

import com.simakad.dao.dto.StudentRegistrationRequest;
import com.simakad.dao.entity.NewStudent;
import com.simakad.dao.entity.StudentRegistration;

/**
 * Created by HighDream on 9/25/2016.
 */
public interface StudentRegistrationService {
    NewStudent register(StudentRegistrationRequest studentRegistrationRequest);
    NewStudent findNewStudent(String id);

}
